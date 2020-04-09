package com.app.timesheet.client;

import com.app.timesheet.domain.req.WeeklyRecordTSRequest;
import com.app.timesheet.domain.res.WeeklyRecordTSResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ts")
public interface TSClient {
    @PostMapping("fetch-weekly-record")
    WeeklyRecordTSResponse getWeeklyRecord(@RequestBody WeeklyRecordTSRequest weeklyRecordTSRequest);
}
