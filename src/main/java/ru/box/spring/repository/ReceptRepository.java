package ru.box.spring.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.box.spring.model.Recept;
import ru.box.spring.model.Shop;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReceptRepository {
    private final List<Recept> recepts = new ArrayList<>();

    @PostConstruct
    void init() {
        saveRecept(new Recept(0,"Плов","Второе блюдо",List.of("Рис","мясо","лук"),"Восточное народное блюдо"));
        saveRecept(new Recept(1,"Борщ","Суп",List.of("Свекла","мясо","лук","Капуста"),"Русская народная кухня"));
        saveRecept(new Recept(2,"Треугольники","Выпечка",List.of("Картофель","мясо","лук"),"Татарская народная кухня"));



    }

    private int nextId = 0;

public Recept saveRecept (Recept recept){
    recept.setId(nextId++);
    recepts.add(recept);
    return recept;
}

public List<Recept> ShowAll(){
    return new ArrayList<>(recepts);
}

public Optional<Recept> findByIDRecept(int id){
    return recepts.stream()
            .filter(r->r.getId()==id)
            .findFirst();
}

    public Optional<Recept> findByNameRecept(String name) {
        return recepts.stream()
                .filter(r -> r.getName() != null
                        && r.getName().equalsIgnoreCase(name))
                .findFirst();
    }




}
