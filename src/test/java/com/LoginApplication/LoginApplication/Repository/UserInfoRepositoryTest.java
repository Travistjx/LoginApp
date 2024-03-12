package com.LoginApplication.LoginApplication.Repository;

import com.LoginApplication.LoginApplication.Entity.Role;
import com.LoginApplication.LoginApplication.Entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    void itShouldFindIfUserExistByUsername() {
        // Create userInfo object
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test");
        userInfo.setUserId((long)1);
        userInfo.setPassword("123");
        userInfo.setRole(Role.ROLE_MANAGER);

        // Save object into database
        userInfoRepository.save(userInfo);

        // Get user result when findByUsername("test") is called
        UserInfo user = userInfoRepository.findByUsername("test");

        // Check if user exists and return true if so
        boolean exists = user != null;
        assertThat(exists).isTrue();
    }

    @Test
    void itShouldFindIfUserDoesNotExistByUsername() {
        // Get user result when findByUsername("test") is called
        UserInfo user = userInfoRepository.findByUsername("test");

        // Check if user does not exist and return true if so
        boolean exists = user != null;
        assertThat(exists).isFalse();
    }
}