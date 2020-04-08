package com.app.timesheet.client;

import com.app.timesheet.domain.req.SummaryFetchTSRequest;
import com.app.timesheet.domain.res.SummaryFetchTSResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ts")
public interface TSClient {
    @PostMapping("fetch-summary")
    SummaryFetchTSResponse getSummaryRecords(@RequestBody SummaryFetchTSRequest summaryFetchEMRequest);

}
