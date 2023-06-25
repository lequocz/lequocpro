package com.lequocpro.entity;

import com.lequocpro.model.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String phone;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    private String rePassword;
    private String avatar;
    private Double balance;
    @Enumerated(EnumType.STRING)
    private Role role;
    @CreationTimestamp
    private Date timeCreated;
    @UpdateTimestamp
    private Date timeUpdate;
    @OneToMany()
    private List<SoldTool> soldTools;
    @OneToMany(mappedBy = "account")
    private List<Orders> orders;

}
