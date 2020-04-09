package com.app.timesheet.service;

import com.app.timesheet.client.TSClient;
import com.app.timesheet.domain.DailyRecord;
import com.app.timesheet.domain.dto.DailyRecordDTO;
import com.app.timesheet.domain.req.TemplateRequest;
import com.app.timesheet.domain.req.WeeklyRecordTSRequest;
import com.app.timesheet.domain.res.WeeklyRecordResponse;
import com.app.timesheet.domain.res.WeeklyRecordTSResponse;
import com.app.timesheet.util.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimesheetService {
    private TSClient tsClient;
    private DateConverter dateConverter;

    @Autowired
    public void setTsClient(TSClient tsClient) {
        this.tsClient = tsClient;
    }

    @Autowired
    public void setDateConverter(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }

    public WeeklyRecordResponse getWeeklyRecord(int employeeID, String curDate) {
        // TODO
        // find week ending date from current date (curDate)
        String weekEnding = dateConverter.convertCurDateToWeekending(curDate);
//        String weekEnding = "2018-03-31";

        WeeklyRecordTSRequest weeklyRecordTSRequest = WeeklyRecordTSRequest.builder()
                .employeeId(employeeID)
                .weekEnding(weekEnding)
                .build();

        WeeklyRecordTSResponse weeklyRecordTSResponse = tsClient.getWeeklyRecord(weeklyRecordTSRequest);

        if (weeklyRecordTSResponse == null) {
            return null;
        }

        WeeklyRecordResponse weeklyRecordResponse = new WeeklyRecordResponse();

        List<DailyRecord> dailyRecordList = new ArrayList<>();
        List<DailyRecordDTO> dailyRecordDTOList = weeklyRecordTSResponse.getDailyRecordDTOList();

        for (DailyRecordDTO dailyRecordDTO : dailyRecordDTOList) {
            dailyRecordList.add(getRecord(dailyRecordDTO));
        }

        weeklyRecordResponse.setWeekEnding(weekEnding);
        weeklyRecordResponse.setTotalBillingHours(weeklyRecordTSResponse.getTotalBillingHours());
        weeklyRecordResponse.setTotalCompensatedHours(weeklyRecordTSResponse.getTotalCompensatedHours());
        weeklyRecordResponse.setDailyRecords(dailyRecordList);

        return weeklyRecordResponse;
    }

    private DailyRecord getRecord(DailyRecordDTO dailyRecordDTO) {
        DailyRecord dailyRecord = new DailyRecord();

        dailyRecord.setDate(dailyRecordDTO.getDate());
        dailyRecord.setDay(dailyRecordDTO.getDay());
        dailyRecord.setStartTime(dailyRecordDTO.getStartTime());
        dailyRecord.setEndTime(dailyRecordDTO.getEndTime());
        dailyRecord.setIfFloating(dailyRecordDTO.isIfFloating());
        dailyRecord.setIfHoliday(dailyRecordDTO.isIfHoliday());
        dailyRecord.setIfVacation(dailyRecordDTO.isIfVacation());

        return dailyRecord;
    }

    public boolean setDefaultTemplate(TemplateRequest templateRequest) {


        return true;
    }
}
