package ru.notasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.notasoft.domain.Classifier;

@Repository
public interface ClassifierRepository extends JpaRepository<Classifier, Integer> {
}
