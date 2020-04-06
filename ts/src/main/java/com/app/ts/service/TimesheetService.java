package com.app.ts.service;

import com.app.ts.domain.Timesheet;
import com.app.ts.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesheetService {

    private TimesheetRepository timesheetRepository;

    @Autowired
    public void setTimesheetRepository(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    public List<Timesheet> getAllTimesheet() {
        List<Timesheet> timesheetList = timesheetRepository.findAll();
        return timesheetList;
    }
}
