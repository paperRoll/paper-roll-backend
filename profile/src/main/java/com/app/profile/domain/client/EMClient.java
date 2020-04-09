package com.app.profile.domain.client;

import com.app.profile.domain.req.ProfileFetchEMRequest;
import com.app.profile.domain.req.ProfilePostEMRequest;
import com.app.profile.domain.res.ProfileFetchEMResponse;
import com.app.profile.domain.res.ProfilePostEMResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "em")
public interface EMClient {

    @GetMapping("fetch-employee")
    ProfileFetchEMResponse getEmployeeInfo(@RequestBody ProfileFetchEMRequest profileFetchEMRequest);

    @GetMapping("update-employee")
    ProfilePostEMResponse updateEmployeeInfo(@RequestBody ProfilePostEMRequest profilePostEMRequest);
}
