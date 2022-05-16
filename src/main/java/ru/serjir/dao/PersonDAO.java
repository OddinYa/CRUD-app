package ru.serjir.dao;

import org.springframework.stereotype.Component;
import ru.serjir.models.Persor;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Persor> people;

    {
        people = new ArrayList<>();

        people.add(new Persor(++PEOPLE_COUNT, "Vova"));
        people.add(new Persor(++PEOPLE_COUNT, "Sergey"));
        people.add(new Persor(++PEOPLE_COUNT, "Stepan"));
        people.add(new Persor(++PEOPLE_COUNT, "Artur"));
    }

    public List<Persor> getPeople() {

        return people;

    }

    public Persor findById(int id) {

        return people.stream().filter(people->people.getId()==id).findAny().orElse(null);

    }

}
