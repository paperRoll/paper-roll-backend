package com.app.profile.domain.res;

import com.app.profile.domain.Profile;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProfileFetchResponse {
    Profile profile;
}
