package com.app.timesheet.domain.res;

import com.app.timesheet.domain.dto.SummaryRecordDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SummaryFetchTSResponse {
    private List<SummaryRecordDTO> summaryRecordDTOs;
}
