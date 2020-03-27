package com.doubledigit.solutions.rsvp.app.service;

import com.doubledigit.solutions.rsvp.app.model.Profile;
import com.doubledigit.solutions.rsvp.app.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public boolean addProfile(Profile profile) {
        profileRepository.save(profile);
        return true;
    }

    public List<Profile> findProfiles() {
        return profileRepository.findProfiles();
    }
}
