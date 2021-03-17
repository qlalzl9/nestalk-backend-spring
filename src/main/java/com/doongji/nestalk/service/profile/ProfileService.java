package com.doongji.nestalk.service.profile;

import com.doongji.nestalk.entity.profile.Profile;
import com.doongji.nestalk.entity.user.User;
import com.doongji.nestalk.error.NotFoundException;
import com.doongji.nestalk.repository.profile.ProfileRepository;
import com.doongji.nestalk.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    @Transactional
    public Profile createProfile(String email, String stateMessage, String profileImage, String backgroundImage) {
        Profile profile = new Profile(stateMessage, profileImage, backgroundImage);
        User currentUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException(User.class, email));
        currentUser.updateProfile(profile);

        return profileRepository.save(profile);
    }
}