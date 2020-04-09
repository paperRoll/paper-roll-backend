package com.app.timesheet.domain.req;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WeeklyRecordRequest {

    private int employeeId;

    private String weekEnding;
}
