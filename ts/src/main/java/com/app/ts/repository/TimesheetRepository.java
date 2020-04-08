package com.app.ts.repository;

import com.app.ts.domain.Timesheet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TimesheetRepository extends MongoRepository<Timesheet, String> {

    Optional<Timesheet> findTimesheetByEmployeeId(int employeeId);
}
