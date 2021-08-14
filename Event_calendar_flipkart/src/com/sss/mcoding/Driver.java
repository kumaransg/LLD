package com.sss.mcoding;

import com.sss.mcoding.app.EventCalendar;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Driver {



    public static void main(String args[]) throws IOException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        EventCalendar eventCalendar = new EventCalendar();

        eventCalendar.createUser("A", dateFormat.parse("2021-07-07 9:00:00"), dateFormat.parse("2021-07-07 21:00:00"));
        eventCalendar.createUser("B", dateFormat.parse("2021-07-07 9:00:00"), dateFormat.parse("2021-07-07 21:00:00"));
        eventCalendar.createUser("C", dateFormat.parse("2021-07-07 9:00:00"), dateFormat.parse("2021-07-07 21:00:00"));

        eventCalendar.createTeam("T1", Arrays.asList(new String[]{"A", "B"}));


        eventCalendar.createEvent("E1", Arrays.asList("C"), Arrays.asList("T1"), 1,
                dateFormat.parse("2021-07-07 13:00:00"), dateFormat.parse("2021-07-07 15:00:00"));

//        eventCalendar.createEvent("E2", Collections.emptyList(), Arrays.asList("T1"), 1,
//                dateFormat.parse("2021-07-07 13:00:00"), dateFormat.parse("2021-07-07 15:00:00"));


        eventCalendar.printUser("A");
        eventCalendar.printUser("B");
        eventCalendar.printUser("C");

        eventCalendar.createEvent("E1", Arrays.asList("C"), Arrays.asList("T1"), 1,
                dateFormat.parse("2021-07-07 13:00:00"), dateFormat.parse("2021-07-07 15:00:00"));


//        eventCalendar.createEvent("E3", Collections.emptyList(), Arrays.asList("T1"), 1,
//                dateFormat.parse("2021-07-07 11:00:00"), dateFormat.parse("2021-07-07 13:00:00"));
//
//        eventCalendar.createEvent("E4", Collections.emptyList(), Arrays.asList("T1"), 2,
//                dateFormat.parse("2021-07-07 15:00:00"), dateFormat.parse("2021-07-07 16:00:00"));
//
//        eventCalendar.createEvent("E5", Collections.emptyList(), Arrays.asList("T1"), 3,
//                dateFormat.parse("2021-07-07 19:00:00"), dateFormat.parse("2021-07-07 20:00:00"));

    }

}
