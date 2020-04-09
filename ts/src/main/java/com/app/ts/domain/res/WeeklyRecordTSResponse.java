package com.app.ts.domain.res;

import com.app.ts.domain.dto.DailyRecordDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WeeklyRecordTSResponse {

    private String weekEnding;

    private int totalBillingHours;

    private int totalCompensatedHours;

    private List<DailyRecordDTO> dailyRecordDTOList;
}
