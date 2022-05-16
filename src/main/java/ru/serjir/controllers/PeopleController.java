package ru.serjir.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serjir.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {


    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String getPeople(Model model){

       model.addAttribute("people",personDAO.getPeople());

        return "people";

    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {

       model.addAttribute("person",personDAO.findById(id));


        return "person";

    }
}