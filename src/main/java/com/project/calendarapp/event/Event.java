package com.project.calendarapp.event;

public interface Event {
    void print();

    boolean support(EventType type);
}
