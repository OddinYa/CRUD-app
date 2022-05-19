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

        people.add(new Person(++PEOPLE_COUNT, "Vova","Ivanov","Dswew1@gmax.com"));
        people.add(new Person(++PEOPLE_COUNT, "Sergey","Zhirnov","sdasw@gmax.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Stepan","Shotov","ye@gmax.de"));
        people.add(new Person(++PEOPLE_COUNT, "Artur","Kasavar","er@gd.de"));
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
    public void update(int id,Person personUpdate){

        Person personToBeUpdate = findById(id);

        personToBeUpdate.setName(personUpdate.getName());
        personToBeUpdate.setSurname(personUpdate.getSurname());
        personToBeUpdate.setEmail(personUpdate.getEmail());
    }

    public void delete(int id){
        people.removeIf(p ->p.getId()==id);
    }

}
