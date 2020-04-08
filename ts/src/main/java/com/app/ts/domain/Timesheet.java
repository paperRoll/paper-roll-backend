package com.app.ts.domain;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@QueryEntity
@Document(collection = "timesheet")
public class Timesheet {

    @Id
    private String id;

    private int employeeId;

    private List<WeeklyRecord> weeklyRecords;

    private List<DailyRecord> defaultTemplate;

}
