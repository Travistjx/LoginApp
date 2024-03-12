package com.LoginApplication.LoginApplication.Service.ServiceImpl;

import com.LoginApplication.LoginApplication.Dto.UserInfoDto;
import com.LoginApplication.LoginApplication.Entity.Role;
import com.LoginApplication.LoginApplication.Entity.UserInfo;
import com.LoginApplication.LoginApplication.Repository.UserInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserInfoServiceImplTest {

    @Mock
    private UserInfoRepository userInfoRepository;

    private UserInfoServiceImpl userInfoService;

    @BeforeEach
    void setup(){
        userInfoService = new UserInfoServiceImpl(userInfoRepository);
    }

    @Test
    void itShouldFindUserByUsernameAndReturnUserWhenFound() {
        // Create new userInfo object
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test");
        userInfo.setUserId((long)1);
        userInfo.setRole(Role.ROLE_MANAGER);

        // Mock return userInfo object when findByUser("test") method is called
        when(userInfoRepository.findByUsername("test")).thenReturn(userInfo);

        // Get result when findUserByUsername method is called
        UserInfoDto result = userInfoService.findUserByUsername("test");

        // Check if result exists and details are correct
        assertNotNull(result);
        assertEquals("test", result.getUsername());
        assertEquals((long) 1, result.getUserId());
        assertEquals(Role.ROLE_MANAGER, result.getRole());
    }

    @Test
    void itShouldFindUserByUsernameAndReturnNullWhenUserDoesNotExist() {
        // Mock return null when findByUser("test") method is called
        when(userInfoRepository.findByUsername("test")).thenReturn(null);

        // Get result when findUserByUsername method is called
        UserInfoDto result = userInfoService.findUserByUsername("test");

        // Check that result is null since user does not exist
        assertNull(result);
    }
}