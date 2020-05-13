package ru.notasoft.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.notasoft.domain.Classifier;
import ru.notasoft.domain.Event;


@Component
public class RepositoryImpl implements Repository {

    private EventRepository eventRepository;

    private ClassifierRepository classifierRepository;

    public RepositoryImpl(EventRepository eventRepository, ClassifierRepository classifierRepository) {
        this.eventRepository = eventRepository;
        this.classifierRepository = classifierRepository;
    }

    @Override
    public Event addEvent(Event event) {
        return this.eventRepository.save(event);
    }

    /**
     * returns the page of events.
     * @param page starts from 0.
     * @param lines lines quantity on the page
     * @return
     */
    @Override
    public Page<Event> getPage(int page, int lines) {
        Pageable requiredPage = PageRequest.of(page, lines, Sort.by("date"));
        return this.eventRepository.findAll(requiredPage);
    }

    /**
     * returns the page of events filtered by the classifier.
     * @param page starts from 0.
     * @param lines lines quantity on the page.
     * @param classifier the classifier.
     * @return
     */
    @Override
    public Page<Event> getPageByClassifier(int page, int lines, Classifier classifier) {
        Pageable requiredPage = PageRequest.of(page, lines, Sort.by("date"));
        return this.eventRepository.findAllByClassifier(classifier, requiredPage);
    }
}
