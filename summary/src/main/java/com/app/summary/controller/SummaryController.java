package com.app.summary.controller;


import com.app.summary.domain.SummaryRecord;
import com.app.summary.domain.res.SummaryFetchResponse;
import com.app.summary.service.SummaryService;
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
@Api(tags = {"Summary - composite service"})
public class SummaryController {

    private SummaryService summaryService;

    @Autowired
    public void setSummaryService(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping("fetch-summary")
    @ApiOperation(value = "Get the summary records for the current employee", response = SummaryFetchResponse.class)
    public ResponseEntity<SummaryFetchResponse> getSummaryInfo(@RequestHeader("employeeId") Integer employeeId) {

        if(employeeId == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        SummaryFetchResponse summaryFetchResponse = new SummaryFetchResponse();
        List<SummaryRecord> summaryRecords = summaryService.getSummaryRecords(employeeId);

        summaryFetchResponse.setSummaryRecords(summaryRecords);

        return new ResponseEntity<>(summaryFetchResponse, HttpStatus.OK);
    }
}
