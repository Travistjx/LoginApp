package com.LoginApplication.LoginApplication.Dto;

import com.LoginApplication.LoginApplication.Entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {

    private Long userId;
    private String name;
    private String username;
    private Role role;
}
