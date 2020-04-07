package com.app.summary.domain;

import lombok.*;

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
