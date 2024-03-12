package com.LoginApplication.LoginApplication.Service.ServiceImpl;

import com.LoginApplication.LoginApplication.Dto.UserInfoDto;
import com.LoginApplication.LoginApplication.Entity.UserInfo;
import com.LoginApplication.LoginApplication.Repository.UserInfoRepository;
import com.LoginApplication.LoginApplication.Service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    // Find userInfo through username and save them into a UserInfoDto object
    public UserInfoDto findUserByUsername (String username) {
        // call on userInfoRepository to find user by username
        UserInfo userInfo = userInfoRepository.findByUsername(username);

        // If user is found
        if (userInfo != null) {
            // Create new UserInfoDto object
            UserInfoDto userInfoDto = new UserInfoDto();

            // Save userInfo info into userInfoDto
            userInfoDto.setUsername(userInfo.getUsername());
            userInfoDto.setName(userInfo.getName());
            userInfoDto.setRole(userInfo.getRole());
            userInfoDto.setUserId(userInfo.getUserId());
            return userInfoDto;
        }
        // If user not found, return null
        else {
            return null;
        }
    }
}
