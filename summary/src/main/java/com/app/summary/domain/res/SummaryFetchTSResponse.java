package com.app.summary.domain.res;

import com.app.summary.domain.dto.SummaryRecordDTO;
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
