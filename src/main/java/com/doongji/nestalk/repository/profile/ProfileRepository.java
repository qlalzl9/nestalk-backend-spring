package com.doongji.nestalk.repository.profile;

import com.doongji.nestalk.entity.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ProfileRepository extends JpaRepository <Profile, Long> {
}