package com.app.ts.service;

import com.app.ts.domain.dto.SummaryRecordDTO;
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

    public List<SummaryRecordDTO> getSummaryRecordsByEmployeeId(int employeeId) {

        List<SummaryRecordDTO> summaryRecordDTOs = new ArrayList<>();
        List<WeeklyRecord> weeklyRecords = getWeeklyRecordsByEmployeeId(employeeId);

        if(weeklyRecords == null) {
            return null;
        }

        for(WeeklyRecord weeklyRecord : weeklyRecords) {
            summaryRecordDTOs.add(getSummaryRecord(weeklyRecord));
        }

        return summaryRecordDTOs;
    }

    private SummaryRecordDTO getSummaryRecord(WeeklyRecord weeklyRecord) {
        SummaryRecordDTO summaryRecordDTO = new SummaryRecordDTO();

        summaryRecordDTO.setWeekEnding(weeklyRecord.getWeekEnding());
        summaryRecordDTO.setTotalBillingHours(weeklyRecord.getTotalBillingHours());
        summaryRecordDTO.setTotalCompensatedHours(weeklyRecord.getTotalCompensatedHours());
        summaryRecordDTO.setSubmissionStatus(weeklyRecord.getSubmissionStatus());
        summaryRecordDTO.setApprovalStatus(weeklyRecord.getApprovalStatus());
        summaryRecordDTO.setComment(weeklyRecord.getComment());

        return summaryRecordDTO;
    }
}
