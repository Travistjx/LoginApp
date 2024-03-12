package com.LoginApplication.LoginApplication.Controller;

import com.LoginApplication.LoginApplication.Dto.UserInfoDto;
import com.LoginApplication.LoginApplication.Entity.Role;
import com.LoginApplication.LoginApplication.Service.UserInfoService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserInfoService userInfoService;

    public HomeController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    // Display Home page
    @GetMapping("/home")
    public String displayHomePage(Model model, @AuthenticationPrincipal UserDetails userDetails){
        // Get username using stored userInfo in userDetails
        String username = userDetails.getUsername();

        // Get userInfoDto using userInfoService
        UserInfoDto userInfoDto = userInfoService.findUserByUsername(username);

        // Get name and role
        String name = userInfoDto.getName();
        Role role = userInfoDto.getRole();

        // Add attributes to model
        model.addAttribute("username", username);
        model.addAttribute("name", name);
        model.addAttribute("role", role);
        return "home";
    }

    // Display restricted page (Only for Managers)
    @GetMapping("/home/restricted")
    public String displayRestrictedPage() {
        return "restricted";
    }
}
