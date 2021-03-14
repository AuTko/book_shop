package bookShop.BookShop.controller;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.Role;
import bookShop.BookShop.service.PersonService;
import bookShop.BookShop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService, RoleService roleService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public String findAll(Model model) {
        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "person-list";
    }

    @GetMapping("/person-create")
    public String createPersonForm(Person person) {
        return "person-create";
    }

    @PostMapping
    public String createPerson(Person person) {
        personService.saveUser(person);
        return"redirect:/persons";
    }
}
