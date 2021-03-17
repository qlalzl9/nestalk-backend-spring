package com.doongji.nestalk.controller.v1.profile.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileRequest {

    @ApiModelProperty(value = "상태 메시지")
    private String stateMessage;

    @ApiModelProperty(value = "프로필 이미지")
    private String profileImage;

    @ApiModelProperty(value = "배경화면")
    private String backgroundImage;
}
