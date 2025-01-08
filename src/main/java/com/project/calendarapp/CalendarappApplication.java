package com.project.calendarapp;

import com.project.calendarapp.event.*;
import com.project.calendarapp.reader.EventCsvReader;
import com.project.calendarapp.reader.RawCsvReader;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class CalendarappApplication {

    public static void main(String[] args) throws IOException {
        Schedule schedule = new Schedule();

        EventCsvReader csvReader = new EventCsvReader(new RawCsvReader());
        String meetingCsvPath = "/data/meeting.csv";
        String toDoCsvPath = "/data/to_do.csv";
        String noDisturbanceCsvPath = "/data/no_disturbance.csv";
        String outOfOfficeCsvPath = "/data/out_of_office.csv";


        List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
        meetings.forEach(schedule::add);

        List<Todo> todos = csvReader.readTodos(toDoCsvPath);
        todos.forEach(schedule::add);

        List<NoDisturbance> noDisturvances = csvReader.readNoDisturbances(noDisturbanceCsvPath);
        noDisturvances.forEach(schedule::add);

        List<OutOfOffice> outOfOffices = csvReader.readOutOfOffices(outOfOfficeCsvPath);
        outOfOffices.forEach(schedule::add);

        schedule.printAll();

//        Meeting meeting = meetings.get(0);
//        meeting.print();

//        System.out.println("수정 후...");

        // update
//        meetings.get(0).validateAndUpdate(
//                new UpdateMeeting(
//                        "new title",
//                        ZonedDateTime.now(),
//                        ZonedDateTime.now().plusHours(1),
//                        null,
//                        "A",
//                        "new agenda"
//                )
//        );
//        meeting.print();

        // 삭제
//        meeting.delete(true);
//        System.out.println("삭제 후 수정 시도");
//        meetings.get(0).validateAndUpdate(
//                new UpdateMeeting(
//                        "new title2",
//                        ZonedDateTime.now(),
//                        ZonedDateTime.now().plusHours(1),
//                        null,
//                        "B",
//                        "new agenda2"
//                )
//        );



        // 전체출력
//        schedule.printAll();

        // 일부 출력
//        schedule.printBy(EventType.TO_DO);
    }

}
