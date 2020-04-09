package com.app.profile.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Profile {

    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private EmergencyContact emergencyContact1;
    private EmergencyContact emergencyContact2;

}
