package ru.notasoft.service;

import ru.notasoft.domain.Event;

import java.util.List;

public interface EventService {

    Event addEvent(Event event);

    List<Event> getPage(int page, int lines, Integer qualifier);
}
