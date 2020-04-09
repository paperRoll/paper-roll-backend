package com.app.timesheet.controller;

import com.app.timesheet.domain.req.TemplateRequest;
import com.app.timesheet.domain.res.WeeklyRecordResponse;
import com.app.timesheet.domain.res.WeeklyRecordTSResponse;
import com.app.timesheet.service.TimesheetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"Timesheet - composite service"})
public class TimesheetController {
    private TimesheetService timesheetService;

    @Autowired
    public void setTimesheetService(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @GetMapping("fetch-weekly-record")
    @ApiOperation(value = "Get the weekly record for current date", response = WeeklyRecordTSResponse.class)
    public ResponseEntity<WeeklyRecordResponse> getWeeklyRecord(@RequestHeader("employeeID") Integer employeeID, @RequestHeader("curDate") String curDate) {

        if (employeeID == null || curDate == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        WeeklyRecordResponse weeklyRecordTSResponse = timesheetService.getWeeklyRecord(employeeID, curDate);

        return new ResponseEntity<>(weeklyRecordTSResponse, HttpStatus.OK);
    }

    @PostMapping("set-default-template")
    public ResponseEntity setDefaultTemplate(@RequestBody TemplateRequest templateRequest) {
        if (templateRequest == null) {
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }

        boolean setTemplate = timesheetService.setDefaultTemplate(templateRequest);

        return new ResponseEntity(null, HttpStatus.OK);
    }
}
