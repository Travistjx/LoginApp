package com.LoginApplication.LoginApplication.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserInfo {

    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // primary key
    private String name;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
