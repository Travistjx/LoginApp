package com.LoginApplication.LoginApplication.Repository;

import com.LoginApplication.LoginApplication.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername (String username); // Find userInfo using username
}
