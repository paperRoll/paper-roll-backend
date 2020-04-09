package com.app.ts.domain.res;

import com.app.ts.domain.dto.SummaryRecordDTO;
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
