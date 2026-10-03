package ru.box.spring.repository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.box.spring.model.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

public class ShopRepository {

    private final List<Shop> shops = new ArrayList<>();

    @PostConstruct
    void init() {
        save(new Shop(0, "Спортмастер", "+7 (843) 000-00-00",
                "info@sportmaster.ru", "sportmaster.ru", "спортивный",
                "Магазин спортивных товаров и одежды"));

        save(new Shop(1,"Пятёрочка", "+7 (843) 111-11-11",
                "info@5ka.ru", "5ka.ru", "продовольственный",
                "Сеть продуктовых магазинов у дома"));

        save(new Shop(2,"СтройМастер", "+7 (843) 222-22-22",
                "info@stroymaster.ru", "stroymaster.ru", "хозяйственный",
                "Инструменты, стройматериалы, сантехника"));
    }

    public Shop save(Shop shop) {
        shops.add(shop);
        return shop;
    }

    public List<Shop> findAll() {
        return new ArrayList<>(shops);
    }

    public Optional<Shop> findById(int id) {
        return shops.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    public Optional<Shop> findByWebSite(String webSite) {
        return shops.stream()
                .filter(s -> s.getWebSite() != null
                        && s.getWebSite().equalsIgnoreCase(webSite))
                .findFirst();
    }
}
