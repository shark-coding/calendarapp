package com.project.calendarapp;

import com.project.calendarapp.event.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class CalendarappApplication {

    public static void main(String[] args) {
        Schedule schedule = new Schedule();

        // 참석자
        HashSet<String> participants = new HashSet<String>();
        participants.add("victoria");

        Meeting meeting1 = new Meeting(
                1, "meeting1",
                ZonedDateTime.now(), ZonedDateTime.now().plusHours(1),
                participants, "meetingRoomA",
                "study"
        );
        schedule.add(meeting1);

        Todo todo1 = new Todo(
                2, "todo1",
                ZonedDateTime.now().plusHours(3), ZonedDateTime.now().plusHours(4),
                "할 일 적기"
        );
        schedule.add(todo1);

        // 전체출력
        schedule.printAll();

        // 일부 출력
        schedule.printBy(EventType.TO_DO);
    }

}
