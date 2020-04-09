package com.app.ts.service;

import com.app.ts.domain.DailyRecord;
import com.app.ts.domain.dto.DailyRecordDTO;
import com.app.ts.domain.dto.SummaryRecordDTO;
import com.app.ts.domain.Timesheet;
import com.app.ts.domain.WeeklyRecord;
import com.app.ts.domain.res.WeeklyRecordTSResponse;
import com.app.ts.repository.TimesheetRepository;
import com.app.ts.util.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimesheetService {

    private TimesheetRepository timesheetRepository;
    private DateConverter dateConverter;

    @Autowired
    public void setTimesheetRepository(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    @Autowired
    public void setDateConverter(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
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
            summaryRecordDTOs.add(getSummaryRecordDTO(weeklyRecord));
        }

        return summaryRecordDTOs;
    }

    private SummaryRecordDTO getSummaryRecordDTO(WeeklyRecord weeklyRecord) {
        SummaryRecordDTO summaryRecordDTO = new SummaryRecordDTO();

        summaryRecordDTO.setWeekEnding(weeklyRecord.getWeekEnding());
        summaryRecordDTO.setTotalBillingHours(weeklyRecord.getTotalBillingHours());
        summaryRecordDTO.setTotalCompensatedHours(weeklyRecord.getTotalCompensatedHours());
        summaryRecordDTO.setSubmissionStatus(weeklyRecord.getSubmissionStatus());
        summaryRecordDTO.setApprovalStatus(weeklyRecord.getApprovalStatus());
        summaryRecordDTO.setComment(weeklyRecord.getComment());

        return summaryRecordDTO;
    }

    public WeeklyRecordTSResponse getWeeklyRecords(int employeeId, String weekEnding) {
        Timesheet timesheet = findTimesheetByEmployeeId(employeeId);
        if (timesheet == null) {
            return null;
        }

        List<WeeklyRecord> weeklyRecords = timesheet.getWeeklyRecords();

        for (WeeklyRecord weeklyRecord : weeklyRecords) {
            if (weeklyRecord.getWeekEnding().equals(weekEnding)) {
                return getDailyRecordsByWeekEnding(weeklyRecord);
            }
        }

        return getDailyRecordsByTemplate(timesheet.getDefaultTemplate(), weekEnding);
    }

    private WeeklyRecordTSResponse getDailyRecordsByTemplate(List<DailyRecord> defaultTemplate, String weekEnding) {
        WeeklyRecordTSResponse weeklyRecordTSResponse = new WeeklyRecordTSResponse();

        List<DailyRecordDTO> dailyRecordDTOS = new ArrayList<>();

        List<String> dates = dateConverter.getDatesFromWeekEnding(weekEnding, defaultTemplate.size());

        for (int i = 0; i < defaultTemplate.size(); i++) {
            DailyRecordDTO dailyRecordDTO = new DailyRecordDTO();

            dailyRecordDTO.setDate(dates.get(i));
            dailyRecordDTO.setDay(defaultTemplate.get(i).getDay());
            dailyRecordDTO.setStartTime(defaultTemplate.get(i).getStartTime());
            dailyRecordDTO.setEndTime(defaultTemplate.get(i).getEndTime());
            dailyRecordDTO.setIfFloating(defaultTemplate.get(i).isIfFloating());
            dailyRecordDTO.setIfHoliday(defaultTemplate.get(i).isIfHoliday());
            dailyRecordDTO.setIfVacation(defaultTemplate.get(i).isIfVacation());

            dailyRecordDTOS.add(dailyRecordDTO);
        }

        weeklyRecordTSResponse.setDailyRecordDTOList(dailyRecordDTOS);
        weeklyRecordTSResponse.setTotalBillingHours(0);
        weeklyRecordTSResponse.setTotalCompensatedHours(0);
        return weeklyRecordTSResponse;
    }

    private WeeklyRecordTSResponse getDailyRecordsByWeekEnding(WeeklyRecord weeklyRecord) {
        WeeklyRecordTSResponse weeklyRecordTSResponse = new WeeklyRecordTSResponse();
        List<DailyRecordDTO> dailyRecordDTOS = new ArrayList<>();
        List<DailyRecord> dailyRecords = weeklyRecord.getDailyRecords();

        int totalBillingHours = weeklyRecord.getTotalBillingHours();
        int totalCompensatedHours = weeklyRecord.getTotalCompensatedHours();

        for (DailyRecord dailyRecord : dailyRecords) {
            DailyRecordDTO dailyRecordDTO = new DailyRecordDTO();

            dailyRecordDTO.setDate(dailyRecord.getDate());
            dailyRecordDTO.setDay(dailyRecord.getDay());
            dailyRecordDTO.setStartTime(dailyRecord.getStartTime());
            dailyRecordDTO.setEndTime(dailyRecord.getEndTime());
            dailyRecordDTO.setIfFloating(dailyRecord.isIfFloating());
            dailyRecordDTO.setIfHoliday(dailyRecord.isIfHoliday());
            dailyRecordDTO.setIfVacation(dailyRecord.isIfVacation());

            dailyRecordDTOS.add(dailyRecordDTO);
        }

        weeklyRecordTSResponse.setDailyRecordDTOList(dailyRecordDTOS);
        weeklyRecordTSResponse.setTotalBillingHours(totalBillingHours);
        weeklyRecordTSResponse.setTotalCompensatedHours(totalCompensatedHours);

        return weeklyRecordTSResponse;
    }
}
