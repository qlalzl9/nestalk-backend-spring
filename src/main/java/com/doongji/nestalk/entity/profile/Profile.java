package com.doongji.nestalk.entity.profile;

import com.doongji.nestalk.entity.BaseTimeEntity;
import com.doongji.nestalk.entity.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.google.common.base.Preconditions.checkArgument;
import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROFILE_ID")
    private Long profileId;

    @Column(name = "STATE_MESSAGE")
    private String stateMessage;

    @Column(name = "IMAGE_URL")
    private String profileImage;

    @Column(name = "BACKGROUND_URL")
    private String backgroundImage;

    @OneToOne(mappedBy = "profile", fetch = LAZY)
    private User user;

    public Profile(String stateMessage, String profileImage, String backgroundImage) {
        this(null, stateMessage, profileImage, backgroundImage);
    }

    public Profile(Long profileId, String stateMessage, String profileImage, String backgroundImage) {
        checkArgument(
                stateMessage.length() <= 100,
                "stateMessage length must be 100 or less"
        );

        this.profileId = profileId;
        this.stateMessage = stateMessage;
        this.profileImage = profileImage;
        this.backgroundImage = backgroundImage;
    }
}
