package com.app.timesheet.domain.res;

import com.app.timesheet.domain.DailyRecord;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WeeklyRecordResponse {

    private String weekEnding;

    private int totalBillingHours;

    private int totalCompensatedHours;

    private List<DailyRecord> dailyRecords;
}
