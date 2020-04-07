package com.app.ts.service;

import com.app.ts.domain.dto.SummaryRecord;
import com.app.ts.domain.Timesheet;
import com.app.ts.domain.WeeklyRecord;
import com.app.ts.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimesheetService {

    private TimesheetRepository timesheetRepository;

    @Autowired
    public void setTimesheetRepository(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    public List<Timesheet> getAllTimesheet() {
        List<Timesheet> timesheetList = timesheetRepository.findAll();
        return timesheetList;
    }

    public Timesheet findTimesheetByEmployeeId(int employeeId) {
        return timesheetRepository.findTimesheetByEmployeeId(employeeId).orElse(null);
    }

    public List<WeeklyRecord> getWeeklyRecordsByEmployeeId(int employeeId) {
        Timesheet timesheet = findTimesheetByEmployeeId(employeeId);

        return timesheet == null ? null : timesheet.getWeeklyRecords();
    }

    public List<SummaryRecord> getSummaryRecordsByEmployeeId(int employeeId) {

        //TODO: uncomment this line when have DTO
//        return DTOClient.getSummaryRecords(getWeeklyRecordsByEmployeeId(employeeId));

        List<SummaryRecord> summaryRecords = new ArrayList<>();
        List<WeeklyRecord> weeklyRecords = getWeeklyRecordsByEmployeeId(employeeId);

        for(WeeklyRecord weeklyRecord : weeklyRecords) {
            summaryRecords.add(getSummaryRecord(weeklyRecord));
        }

        return summaryRecords;
    }

    // this function should be at DTO service,
    // but right now, just simplify include it directly here
    private SummaryRecord getSummaryRecord(WeeklyRecord weeklyRecord) {
        SummaryRecord summaryRecord = new SummaryRecord();

        summaryRecord.setWeekEnding(weeklyRecord.getWeekEnding());
        summaryRecord.setTotalBillingHours(weeklyRecord.getTotalBillingHours());
        summaryRecord.setTotalCompensatedHours(weeklyRecord.getTotalCompensatedHours());
        summaryRecord.setSubmissionStatus(weeklyRecord.getSubmissionStatus());
        summaryRecord.setApprovalStatus(weeklyRecord.getApprovalStatus());
        summaryRecord.setComment(weeklyRecord.getComment());

        return summaryRecord;
    }
}
