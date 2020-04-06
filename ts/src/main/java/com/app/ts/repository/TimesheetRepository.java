package com.app.ts.repository;

import com.app.ts.domain.Timesheet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimesheetRepository extends MongoRepository<Timesheet, String> {

}
