package ru.serjir.dao;

import org.springframework.stereotype.Component;
import ru.serjir.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Vova"));
        people.add(new Person(++PEOPLE_COUNT, "Sergey"));
        people.add(new Person(++PEOPLE_COUNT, "Stepan"));
        people.add(new Person(++PEOPLE_COUNT, "Artur"));
    }

    public List<Person> getPeople() {

        return people;

    }

    public Person findById(int id) {

        return people.stream().filter(people->people.getId()==id).findAny().orElse(null);

    }

    public void save(Person person){

        person.setId(++PEOPLE_COUNT);
        people.add(person);

    }

}
