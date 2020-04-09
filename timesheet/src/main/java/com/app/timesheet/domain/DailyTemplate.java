package com.app.timesheet.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DailyTemplate {

    private String date;

    private String startTime;

    private String endTime;

    private int totalHours;

    private boolean ifFloating;

    private boolean ifHoliday;

    private boolean ifVacation;
}
