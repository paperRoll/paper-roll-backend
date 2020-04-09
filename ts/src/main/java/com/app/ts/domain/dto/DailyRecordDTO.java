package com.app.ts.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DailyRecordDTO {

    private String day;

    private String date;

    private String startTime;

    private String endTime;

    private int totalHours;

    private boolean ifFloating;

    private boolean ifHoliday;

    private boolean ifVacation;
}
