package com.LoginApplication.LoginApplication.Security;
import com.LoginApplication.LoginApplication.Entity.Role;
import com.LoginApplication.LoginApplication.Entity.UserInfo;
import com.LoginApplication.LoginApplication.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

//  Custom implementation of the UserDetailsService
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private final UserInfoRepository userInfoRepository;

    public CustomUserDetailsService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    // Load user details by username for authentication
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find userInfo using username
        UserInfo userInfo = userInfoRepository.findByUsername(username);

        if (userInfo != null) {
            // Creating a UserDetails object with user information and authorities.
            return new org.springframework.security.core.userdetails.User(
                    userInfo.getUsername(),
                    userInfo.getPassword(),
                    mapRolesToAuthorities(userInfo.getRole()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    // Map roles to GrantedAuthority objects
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role) {
        // Mapping a single role to a GrantedAuthority object.
        return Collections.singleton(new SimpleGrantedAuthority(role.name()));
    }
}