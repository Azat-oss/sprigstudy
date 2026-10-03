package ru.box.spring.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.box.spring.model.Fraction;
import ru.box.spring.repository.FractionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/fractions")

public class FractionController {

    private final FractionRepository repository;

    public FractionController(FractionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Fraction> list() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Fraction> create(@Valid @RequestBody Fraction fraction) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(fraction));
    }


}
