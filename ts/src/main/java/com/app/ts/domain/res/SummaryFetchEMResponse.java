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
public class SummaryFetchEMResponse {

    private List<SummaryRecordDTO> summaryRecordDTOs;

}
