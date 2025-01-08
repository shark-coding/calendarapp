package com.project.calendarapp.event;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<AbstractEvent> events = new ArrayList<>();

    // 일정 추가
    public void add(AbstractEvent event){
        if (hasScheduleConfilictWith(event)){
            return;
        }
        this.events.add(event);
    }

    // 전체 출력
    public void printAll() {
        events.forEach(Event::print);
    }

    // 원하는 것만 출력
    public void printBy(EventType type) {
        events.stream()
                .filter(event -> event.support(type))
                .forEach(Event::print);
    }

    // 시작시간이나 종료시간 겹치는게 발생하는 지
    private boolean hasScheduleConfilictWith(AbstractEvent event){
        return events.stream()
                .anyMatch(each ->
                        (event.getStartAt().isBefore(each.getEndAt()) &&
                                event.getStartAt().isAfter(each.getStartAt())));
    }
}
