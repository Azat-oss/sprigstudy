package ru.box.spring.controller;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.box.spring.model.Shop;
import ru.box.spring.repository.ShopRepository;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopRepository repository;

    public ShopController(ShopRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public List<ListItem> list() {
        return repository.findAll().stream()
                .map(s -> new ListItem(s.getId(), s.getName(), s.getCategory()))
                .toList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Shop> byId(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/search")
    public ResponseEntity<Shop> byWebSite(@RequestParam String site) {
        return repository.findByWebSite(site)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Shop> create(@Valid @RequestBody Shop shop) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(shop));
    }


    public record ListItem(int id, String name, String category) {}



}
