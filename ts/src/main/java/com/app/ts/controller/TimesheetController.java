package com.app.ts.controller;

import com.app.ts.domain.Timesheet;
import com.app.ts.service.TimesheetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"TS - core service"})
public class TimesheetController {

    private TimesheetService timesheetService;

    @Autowired
    public void setTimesheetService(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @GetMapping("all")
    @ApiOperation(value = "List all Timesheet", response = Timesheet.class)
    public List<Timesheet> getAllTimesheet() { return timesheetService.getAllTimesheet(); }
}
