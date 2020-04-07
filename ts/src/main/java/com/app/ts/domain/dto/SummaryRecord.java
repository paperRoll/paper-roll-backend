package com.app.ts.domain.dto;

import lombok.*;

// this file should be at DTO service,
// but right now, just simplify include it directly here
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SummaryRecord {

    private String weekEnding;

    private int totalBillingHours;

    private int totalCompensatedHours;

    private String submissionStatus;

    private String approvalStatus;

    private String comment;
}
