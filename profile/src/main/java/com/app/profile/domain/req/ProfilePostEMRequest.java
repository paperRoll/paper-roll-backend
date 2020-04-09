package com.app.profile.domain.req;

import com.app.profile.domain.dto.ProfileDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProfilePostEMRequest {
    private int employeeId;
    private ProfileDTO profileDTO;
}
