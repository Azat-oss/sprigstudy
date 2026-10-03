package ru.box.spring.repository;

import org.springframework.stereotype.Repository;
import ru.box.spring.model.Fraction;

import java.util.ArrayList;
import java.util.List;

@Repository

public class FractionRepository {

    private final List<Fraction> fractions = new ArrayList<>();

    public Fraction save(Fraction fraction) {
        fractions.add(fraction);
        return fraction;
    }

    public List<Fraction> findAll() {
        return new ArrayList<>(fractions);
    }

}
