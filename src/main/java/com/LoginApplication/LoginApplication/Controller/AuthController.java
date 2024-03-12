package com.LoginApplication.LoginApplication.Controller;

import com.LoginApplication.LoginApplication.Entity.Role;
import com.LoginApplication.LoginApplication.Repository.UserInfoRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Collection;

@Controller
public class AuthController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    // Display Login PAge
    @GetMapping("/login")
    public String displayLoginPage(){
        return "login";
    }

    // Display access denied page for unauthorized pages
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
