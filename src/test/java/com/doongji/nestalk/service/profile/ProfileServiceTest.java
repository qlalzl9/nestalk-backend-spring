package com.doongji.nestalk.service.profile;

import com.doongji.nestalk.entity.profile.Profile;
import com.doongji.nestalk.entity.user.User;
import com.doongji.nestalk.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProfileServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private ProfileService profileService;

    private String email;

    private String name;

    private String password;

    private String phone;

    private LocalDate birthday;

    private User user;

    private String stateMessage;

    private String profileImage;

    private String backgroundImage;

    @BeforeAll
    void setup() {
        name = "둥지";
        email = "doongji.team@gmail.com";
        password = "P@ssword1";
        phone = "010-0000-0000";
        birthday = LocalDate.of(1995, 2, 19);
        stateMessage = "상태 메시지";
        profileImage = "프로필 이미지";
        backgroundImage = "배경화면";
    }

    @Test
    @Order(1)
    void 사용자_회원가입() {
        User user = userService.join(email, name, password, phone, birthday);
        this.user = user;
        log.info("User: {}", user);
    }

    @Test
    @Order(2)
    void 프로필_등록() {
        User user = userService.findByEmail(email).orElse(null);
        Profile profile = profileService.createProfile(user.getEmail(), stateMessage, profileImage, backgroundImage);
        assertEquals(stateMessage, profile.getStateMessage());
        assertEquals(profileImage, profile.getProfileImage());
        assertEquals(backgroundImage, profile.getBackgroundImage());
        log.info("Profile: {}", profile);
    }
}
