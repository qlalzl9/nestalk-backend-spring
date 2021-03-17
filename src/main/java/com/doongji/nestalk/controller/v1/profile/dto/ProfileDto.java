package com.doongji.nestalk.controller.v1.profile.dto;

import com.doongji.nestalk.entity.profile.Profile;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
@Setter
@ToString
public class ProfileDto {

    @ApiModelProperty(value = "PK")
    private Long profileId;

    @ApiModelProperty(value = "상태 메시지")
    private String stateMessage;

    @ApiModelProperty(value = "프로필 이미지")
    private String profileImage;

    @ApiModelProperty(value = "배경화면")
    private String backgroundImage;

    public ProfileDto(Profile source) {
        copyProperties(source, this);
    }
}