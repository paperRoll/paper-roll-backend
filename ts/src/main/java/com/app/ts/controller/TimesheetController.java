package com.app.ts.controller;

import com.app.ts.domain.Timesheet;
import com.app.ts.domain.dto.SummaryRecordDTO;
import com.app.ts.domain.req.SummaryFetchTSRequest;
import com.app.ts.domain.res.SummaryFetchTSResponse;
import com.app.ts.service.TimesheetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("fetch")
    @ApiOperation(value = "Get the timesheet for the current employee", response = Timesheet.class)
    public ResponseEntity<Timesheet> getTimesheet(@RequestHeader("employeeId") Integer employeeId) {

        if(employeeId == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Timesheet timesheet = timesheetService.findTimesheetByEmployeeId(employeeId);

        return new ResponseEntity<>(timesheet, HttpStatus.OK);
    }

    @PostMapping("fetch-summary")
    @ApiOperation(value = "Get the summary records for the current employee", response = SummaryFetchTSResponse.class)
    public ResponseEntity<SummaryFetchTSResponse> getSummaryRecords(@RequestBody SummaryFetchTSRequest summaryFetchTSRequest) {

        int employeeId = summaryFetchTSRequest.getEmployeeId();

        SummaryFetchTSResponse summaryFetchTSResponse = new SummaryFetchTSResponse();
        List<SummaryRecordDTO> summaryRecordDTOs = timesheetService.getSummaryRecordsByEmployeeId(employeeId);

        summaryFetchTSResponse.setSummaryRecordDTOs(summaryRecordDTOs);

        return new ResponseEntity<>(summaryFetchTSResponse, HttpStatus.OK);
    }
}
