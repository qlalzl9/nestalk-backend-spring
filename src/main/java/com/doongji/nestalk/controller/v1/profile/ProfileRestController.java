package com.doongji.nestalk.controller.v1.profile;

import com.doongji.nestalk.controller.v1.profile.dto.ProfileDto;
import com.doongji.nestalk.controller.v1.profile.dto.ProfileRequest;
import com.doongji.nestalk.entity.profile.Profile;
import com.doongji.nestalk.security.JwtAuthentication;
import com.doongji.nestalk.service.profile.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "프로필 APIs")
@RequestMapping("api/v1")
@RequiredArgsConstructor
@RestController
public class ProfileRestController {

    private final ProfileService profileService;

    @ApiOperation(value = "프로필 등록 (JWT 필요)")
    @PostMapping(path = "profile/create")
    public ResponseEntity<ProfileDto> createProfile(@AuthenticationPrincipal JwtAuthentication jwtAuthentication,
                                                    @RequestBody ProfileRequest profileRequest) {
        Profile profile = profileService.createProfile(
                jwtAuthentication.email,
                profileRequest.getStateMessage(),
                profileRequest.getProfileImage(),
                profileRequest.getBackgroundImage()
        );

        return ResponseEntity.ok(new ProfileDto(profile));
    }
}
