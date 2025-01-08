package com.project.calendarapp;

import com.project.calendarapp.event.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class CalendarappApplication {

    public static void main(String[] args) {
        List<AbstractEvent> list = new ArrayList<>();

        // 참석자
        HashSet<String> participants = new HashSet<String>();
        participants.add("victoria");

        Meeting meeting1 = new Meeting(
                1, "meeting1",
                ZonedDateTime.now(), ZonedDateTime.now().plusHours(1),
                participants, "meetingRoomA",
                "study"
        );
        list.add(meeting1);

        Todo todo1 = new Todo(
                2, "todo1",
                ZonedDateTime.now(), ZonedDateTime.now().plusHours(2),
                "할 일 적기"
        );
        list.add(todo1);

        // 전체 출력
//        list.stream()
//                .forEach(each -> each.print());
//        list.forEach(Event::print);

        // 원하는 것만 출력
        list.stream()
                .filter(each -> each.support(EventType.TO_DO))
                .forEach(Event::print);

    }

}
