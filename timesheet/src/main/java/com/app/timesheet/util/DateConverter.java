package com.app.timesheet.util;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

@Service
public class DateConverter {
    public String convertCurDateToWeekending(String curDate) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate date = LocalDate.parse(curDate, f);

        LocalDate nextOrSameSaturday =
                date.with( TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));

        return nextOrSameSaturday.toString();
    }
    // function
    // take selected date
    // return weekEnding date

    // function
    // take weekEnding date
    // return list of date -> create default template
}
