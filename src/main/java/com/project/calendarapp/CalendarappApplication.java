package com.project.calendarapp;

import com.project.calendarapp.event.*;
import com.project.calendarapp.event.update.UpdateMeeting;
import com.project.calendarapp.reader.EventCsvReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class CalendarappApplication {

    public static void main(String[] args) throws IOException {
        Schedule schedule = new Schedule();

        EventCsvReader csvReader = new EventCsvReader();
        String meetingCsvPath = "/data/meeting.csv";

        List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
        meetings.forEach(schedule::add);

        Meeting meeting = meetings.get(0);
        meeting.print();

        System.out.println("수정 후...");

        // update
        meetings.get(0).validateAndUpdate(
                new UpdateMeeting(
                        "new title",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        null,
                        "A",
                        "new agenda"
                )
        );
        meeting.print();

        // 삭제
        meeting.delete(true);
        System.out.println("삭제 후 수정 시도");
        meetings.get(0).validateAndUpdate(
                new UpdateMeeting(
                        "new title2",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        null,
                        "B",
                        "new agenda2"
                )
        );



        // 전체출력
//        schedule.printAll();

        // 일부 출력
//        schedule.printBy(EventType.TO_DO);
    }

}
