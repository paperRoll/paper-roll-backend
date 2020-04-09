package com.app.timesheet.service;

import com.app.timesheet.client.TSClient;
import com.app.timesheet.domain.DailyRecord;
import com.app.timesheet.domain.req.WeeklyRecordRequest;
import com.app.timesheet.domain.res.WeeklyRecordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimesheetService {
    private TSClient tsClient;

    @Autowired
    public void setTsClient(TSClient tsClient) {
        this.tsClient = tsClient;
    }

    public List<DailyRecord> getWeeklyRecord(Integer employeeID, String curDate) {
        // TODO
        // find week ending date from current date (curDate)
        String weekEnding = "2018-03-24";
        WeeklyRecordRequest weeklyRecordRequest = WeeklyRecordRequest.builder()
                .employeeId(employeeID)
                .weekEnding(weekEnding)
                .build();
        WeeklyRecordResponse weeklyRecordResponse = tsClient.getWeeklyRecord(weeklyRecordRequest);
        List<DailyRecord> dailyRecordList = new ArrayList<>();

        return dailyRecordList;
    }
}
