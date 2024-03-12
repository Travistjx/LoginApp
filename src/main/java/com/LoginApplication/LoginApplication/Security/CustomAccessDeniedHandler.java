package com.LoginApplication.LoginApplication.Security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//  Custom implementation of the AccessDeniedHandler
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    // Handles access denied situations
    @Override
    public void handle(jakarta.servlet.http.HttpServletRequest request,
                       jakarta.servlet.http.HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        response.sendRedirect("/access-denied"); // Specify the access denied page
    }
}
