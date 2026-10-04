package ru.box.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import ru.box.spring.model.Fraction;
import ru.box.spring.model.Recept;
import ru.box.spring.model.Shop;
import ru.box.spring.repository.ReceptRepository;
import ru.box.spring.repository.ShopRepository;

import java.util.List;


@RestController
@RequestMapping("/api/recepts")


public class ReceptController {

    private final ReceptRepository repository;
    public ReceptController(ReceptRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Recept> list() {
        return repository.ShowAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recept> byId(@PathVariable int id) {
        return repository.findByIDRecept(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search") //http://localhost:8080/api/recepts/search?name=борщ
    public ResponseEntity<Recept> byNameRecept(@RequestParam String name) {
        return repository.findByNameRecept(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Recept> create(@RequestBody Recept recept) {
        Recept saved = repository.saveRecept(recept);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }





}
