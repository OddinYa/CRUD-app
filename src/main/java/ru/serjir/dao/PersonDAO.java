package ru.serjir.dao;

import org.springframework.stereotype.Component;
import ru.serjir.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5050/CRUDDB";
    private static final String USERNAME = "User";
    private static final String PASSWORD = "123";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<Person> getPeople() {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Person person = new Person();

               person.setId(resultSet.getInt("id"));
               person.setName(resultSet.getString("name"));
               person.setSurname(resultSet.getString("surname"));
               person.setEmail(resultSet.getString("email"));

               people.add(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public Person findById(int id) {

//        return people.stream().filter(people->people.getId()==id).findAny().orElse(null);
    return null;
    }

    public void save(Person person) {

        try {
            Statement statement =connection.createStatement();
            String SQL = "INSERT INTO person VALUES("+5+",'"+person.getName()+"','"+
                    person.getSurname()+"','"+person.getEmail()+"')";

            statement.executeUpdate(SQL);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void update(int id, Person personUpdate) {

//        Person personToBeUpdate = findById(id);
//
//        personToBeUpdate.setName(personUpdate.getName());
//        personToBeUpdate.setSurname(personUpdate.getSurname());
//        personToBeUpdate.setEmail(personUpdate.getEmail());
    }

    public void delete(int id) {
//        people.removeIf(p -> p.getId() == id);
    }

}
