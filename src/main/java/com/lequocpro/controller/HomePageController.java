package com.lequocpro.controller;

import com.lequocpro.entity.Account;
import com.lequocpro.model.Role;
import com.lequocpro.repository.ToolRepository;
import com.lequocpro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePageController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private ToolRepository toolRepository;
    @Autowired
    private AccountService accountService;
    @GetMapping(path = {"/","/home"})
    public String getHomePage(Model model){
        model.addAttribute("tools",toolRepository.findAll());
        return "home";
    }
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("account",new Account());
        return "register";
    }
    @PostMapping ("/register")
    public String createAccount(Model model, @ModelAttribute Account account){
        if(accountService.findByUserName(account.getUsername()) == null) {
            String rawPassword = account.getPassword();
            String encryptPassword = passwordEncoder.encode(rawPassword);
            account.setPassword(encryptPassword);
            account.setRole(Role.ROLE_MEMBER);
            accountService.createAccount(account);
            model.addAttribute("account",new Account());
            model.addAttribute("successMessage","Đã đăng ký thành công, vui lòng đăng nhập");
            return "login";
        }
        model.addAttribute("errMessage","Tên đăng nhập đã tồn tại");
        return "register";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("account",new Account());
        return "login";
    }
}
