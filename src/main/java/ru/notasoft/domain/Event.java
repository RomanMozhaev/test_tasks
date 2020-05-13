package ru.notasoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
public class Event {

    @JsonIgnore
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String description;

    private Calendar date;

    @Transient
    private int classifierId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classifier", foreignKey = @ForeignKey(name = "event"))
    private Classifier classifier;

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @JsonIgnore
    public int getClassifierId() {
        return classifierId;
    }

    public void setClassifierId(int classifierId) {
        this.classifierId = classifierId;
    }

    public Classifier getClassifier() {
        return classifier;
    }

    @JsonIgnore
    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Event event = (Event) o;
        return Objects.equals(name, event.name)
                && Objects.equals(description, event.description)
                && Objects.equals(date, event.date)
                && Objects.equals(classifier, event.classifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, date, classifier);
    }
}
