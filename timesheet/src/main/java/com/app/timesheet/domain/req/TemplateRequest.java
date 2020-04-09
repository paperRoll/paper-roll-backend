package com.app.timesheet.domain.req;

import com.app.timesheet.domain.DailyTemplate;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TemplateRequest {

    private List<DailyTemplate> dailyTemplateList;
}
