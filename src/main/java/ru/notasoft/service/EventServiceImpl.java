package ru.notasoft.service;

import org.springframework.stereotype.Service;
import ru.notasoft.domain.Classifier;
import ru.notasoft.domain.Event;
import ru.notasoft.repository.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private Repository repository;

    public EventServiceImpl(Repository repository) {
        this.repository = repository;
    }

    /**
     * adds event to the database.
     * @param event
     * @return
     */
    @Override
    public Event addEvent(Event event) {
        event.setDate(Calendar.getInstance());
        event.setClassifier(new Classifier(event.getClassifierId()));
        Event result = new Event();
        try {
            result = this.repository.addEvent(event);
        } catch (Exception ignored) {
        }
        return result;
    }

    /**
     * returns the sorted page w/o filtration or filtered by the classifier.
     * @param page - page number. first page is 0.
     * @param lines - lines quantity on the one page.
     * @param classifier - if not null, the classifier used for filtering;
     *                   otherwise all events.
     *
     * @return the list of events which contains on the page.
     */
    @Override
    public List<Event> getPage(int page, int lines, Integer classifier) {
        if (classifier == null) {
            return this.repository.getPage(page, lines).getContent();
        }
        if (classifier > 0) {
          return this.repository.getPageByClassifier(page, lines, new Classifier(classifier)).getContent();
        }
        return new ArrayList<>();

    }
}
