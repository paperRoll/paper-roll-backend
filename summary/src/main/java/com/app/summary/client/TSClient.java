package com.app.summary.client;

import com.app.summary.domain.req.SummaryFetchEMRequest;
import com.app.summary.domain.res.SummaryFetchEMResponse;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ts")
public interface TSClient {

    @PostMapping("fetch-summary")
    public SummaryFetchEMResponse getSummaryRecords(@RequestBody SummaryFetchEMRequest summaryFetchEMRequest);

}
