package ru.notasoft.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.notasoft.domain.Event;
import ru.notasoft.service.EventService;
import java.util.List;

@RestController
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping(value = "/addEvent")
    public ResponseEntity<Event> registration(@RequestBody Event event) {
        Event result = this.service.addEvent(event);
        return new ResponseEntity<>(
                result,
                result.getId() > 0 ? HttpStatus.OK : HttpStatus.BAD_REQUEST
        );
    }

    @GetMapping(value = {"/statistic/{page}/{lines}/{qualifier}", "/statistic/{page}/{lines}"})
    public ResponseEntity<List<Event>> statistic(@PathVariable int page,
                                                 @PathVariable int lines,
                                                @PathVariable(name = "qualifier", required = false) Integer qualifierId) {
        List<Event> list = this.service.getPage(page, lines, qualifierId);
        return new ResponseEntity<>(
                list,
                HttpStatus.OK);
    }
}
