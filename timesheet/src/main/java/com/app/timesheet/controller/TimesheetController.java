package com.app.timesheet.controller;

import com.app.timesheet.domain.DailyRecord;
import com.app.timesheet.domain.res.WeeklyRecordResponse;
import com.app.timesheet.service.TimesheetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"Timesheet - composite service"})
public class TimesheetController {
    private TimesheetService timesheetService;

    @Autowired
    public void setTimesheetService(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @GetMapping("fetch-weekly-record")
    @ApiOperation(value = "Get the weekly record for current date", response = WeeklyRecordResponse.class)
    public ResponseEntity<WeeklyRecordResponse> getWeeklyRecord(@RequestHeader("employeeID") Integer employeeID, @RequestHeader("curDate") String curDate) {

        if (employeeID == null || curDate == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        WeeklyRecordResponse weeklyRecordResponse = new WeeklyRecordResponse();
        List<DailyRecord> dailyRecordList = timesheetService.getWeeklyRecord(employeeID, curDate);

        weeklyRecordResponse.setDailyRecords(dailyRecordList);
        return new ResponseEntity<>(weeklyRecordResponse, HttpStatus.OK);
    }
}
