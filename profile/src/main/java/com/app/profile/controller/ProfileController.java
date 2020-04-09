package com.app.profile.controller;

import com.app.profile.domain.Profile;
import com.app.profile.domain.dto.ProfileDTO;
import com.app.profile.domain.res.ProfileFetchResponse;
import com.app.profile.domain.res.ProfilePostEMResponse;
import com.app.profile.service.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"Profile - composite service"})
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("fetch-profile")
    @ApiOperation(value = "Get the employee profile and display on page 'profile'", response = ProfileFetchResponse.class)
    public ResponseEntity<ProfileFetchResponse> getProfile(@RequestHeader("employeeId") Integer employeeId) {
        if(employeeId == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        ProfileFetchResponse profileFetchResponse = new ProfileFetchResponse();
        Profile profile = profileService.getProfile(employeeId);
        profileFetchResponse.setProfile(profile);

        return new ResponseEntity<>((MultiValueMap<String, String>) profile, HttpStatus.OK);
    }

//    public ResponseEntity<ProfilePostEMResponse> updateEmployeeInfo(  @RequestHeader("employeeId") Integer employeeId,
//                                                                     @RequestBody ProfileDTO profileDTO) {
//        if(employeeId == null || profileDTO == null) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//
//        ProfilePostEMResponse profilePostEMResponse = new ProfilePostEMResponse();
//
//
//
//    }
}
