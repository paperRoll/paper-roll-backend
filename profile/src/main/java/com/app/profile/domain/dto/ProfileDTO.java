package com.app.profile.domain.dto;

import com.app.profile.domain.EmergencyContact;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProfileDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private EmergencyContact emergencyContact1;
    private EmergencyContact emergencyContact2;
}
