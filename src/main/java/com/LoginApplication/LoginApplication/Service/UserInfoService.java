package com.LoginApplication.LoginApplication.Service;

import com.LoginApplication.LoginApplication.Dto.UserInfoDto;

public interface UserInfoService {
    UserInfoDto findUserByUsername(String username);
}
