package dev.snowdrop;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {

    private final EntryRepository repository;

    public EntryController(EntryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Entry> get() {
        return repository.findAll();
    }

    @PostMapping
    public long create(@RequestBody String value) {
        return repository.save(new Entry(value)).getId();
    }

    @DeleteMapping
    public void delete() {
        repository.deleteAll();
    }
}
