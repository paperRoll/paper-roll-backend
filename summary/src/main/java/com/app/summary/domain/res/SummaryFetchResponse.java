package com.app.summary.domain.res;

import com.app.summary.domain.SummaryRecord;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SummaryFetchResponse {

    private List<SummaryRecord> summaryRecords;

}
