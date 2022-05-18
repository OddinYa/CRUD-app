package ru.serjir.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.serjir.dao.PersonDAO;
import ru.serjir.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {


    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String getPeople(Model model) {

        model.addAttribute("people", personDAO.getPeople());

        return "people";

    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {

        model.addAttribute("person", personDAO.findById(id));


        return "person";

    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new";

    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person){

        personDAO.save(person);

        return "redirect:/people";

    }
    @GetMapping("/{id}/edit")
    public String edit(Model model , @PathVariable("id") int id){
        model.addAttribute("person",personDAO.findById(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id){
        personDAO.update(id,person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id")int id){
        personDAO.delete(id);
        return "redirect:/people";
    }


}
