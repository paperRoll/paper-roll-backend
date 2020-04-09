package com.app.profile.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmergencyContact {

    private String name;
    private String phoneNumber;

}
