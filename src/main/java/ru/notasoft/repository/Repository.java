package ru.notasoft.repository;

import org.springframework.data.domain.Page;
import ru.notasoft.domain.Classifier;
import ru.notasoft.domain.Event;

public interface Repository {

    Event addEvent(Event event);

    Page<Event> getPage(int page, int lines);

    Page<Event> getPageByClassifier(int page, int lines, Classifier classifier);

}
