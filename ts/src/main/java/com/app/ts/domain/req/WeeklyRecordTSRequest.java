package com.app.ts.domain.req;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WeeklyRecordTSRequest {

    private int employeeId;

    private String weekEnding;
}
