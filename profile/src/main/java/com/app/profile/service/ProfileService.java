package com.app.profile.service;

import com.app.profile.domain.Profile;
import com.app.profile.domain.client.EMClient;
import com.app.profile.domain.dto.ProfileDTO;
import com.app.profile.domain.req.ProfileFetchEMRequest;
import com.app.profile.domain.req.ProfilePostEMRequest;
import com.app.profile.domain.res.ProfileFetchEMResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private EMClient emClient;

    @Autowired
    public void setEmClient(EMClient emClient) {
        this.emClient = emClient;
    }

    public Profile getProfile(int employeeId) {

        ProfileFetchEMRequest profileFetchEMRequest = ProfileFetchEMRequest.builder()
                .employeeId(employeeId)
                .build();

        ProfileFetchEMResponse profileFetchEMResponse = emClient.getEmployeeInfo(profileFetchEMRequest);

        ProfileDTO profileDTO = profileFetchEMResponse.getProfileDTO();

        if(profileDTO == null) {
            return null;
        }

        Profile profile = new Profile();
        profile.builder().name(profileDTO.getName())
                         .email(profileDTO.getEmail())
                         .phoneNumber(profileDTO.getPhoneNumber())
                         .address(profileDTO.getAddress())
                         .emergencyContact1(profileDTO.getEmergencyContact1())
                         .emergencyContact2(profileDTO.getEmergencyContact2())
                         .build();

        return profile;
    }

    public void postProfile(int employeeId, ProfileDTO profileDTO) {
        ProfilePostEMRequest profilePostEMRequest = new ProfilePostEMRequest();

        profilePostEMRequest.builder().employeeId(employeeId).profileDTO(profileDTO);
    }
}
