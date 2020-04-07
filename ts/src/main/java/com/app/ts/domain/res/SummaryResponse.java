package com.app.ts.domain.res;

import com.app.ts.domain.dto.SummaryRecord;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SummaryResponse {

    private List<SummaryRecord> summaryRecords;
}
