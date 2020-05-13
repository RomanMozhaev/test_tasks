package ru.notasoft.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.notasoft.domain.Classifier;
import ru.notasoft.domain.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    Page<Event> findAllByClassifier(Classifier classifier, Pageable requiredPage);
}
