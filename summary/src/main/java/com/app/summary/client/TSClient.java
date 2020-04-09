package com.app.summary.client;

import com.app.summary.domain.req.SummaryFetchTSRequest;
import com.app.summary.domain.res.SummaryFetchTSResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ts")
public interface TSClient {

    @PostMapping("fetch-summary")
    public SummaryFetchTSResponse getSummaryRecords(@RequestBody SummaryFetchTSRequest summaryFetchTSRequest);

}
