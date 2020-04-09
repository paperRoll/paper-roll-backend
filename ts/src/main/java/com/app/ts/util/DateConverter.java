package com.app.ts.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DateConverter {

    // function
    // take selected date
    // return weekEnding date

    // function
    // take weekEnding date
    // return list of date -> create default template
    public List<String> getDatesFromWeekEnding(String weekEnding, int offset) {
        return (Arrays.asList("2018-04-25", "2018-04-26", "2018-04-27", "2018-04-28", "2018-04-29", "2018-04-30", "2018-04-31"));
    }
}
