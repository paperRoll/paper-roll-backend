package com.app.em.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmergencyContact {

    private String firstName;

    private String lastName;

    private String phone;
}
