package com.app.profile.domain.res;

import com.app.profile.domain.dto.ProfileDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProfilePostEMResponse {
    Integer employeeId;
    ProfileDTO profileDTO;
}
