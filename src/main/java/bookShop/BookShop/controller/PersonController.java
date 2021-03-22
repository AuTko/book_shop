package bookShop.BookShop.controller;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.Role;
import bookShop.BookShop.service.PersonService;
import bookShop.BookShop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/*@Controller
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
}*/
@RestController
@RequestMapping("api/ver1/persons/")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService, RoleService roleService) {
        this.personService = personService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Person person = personService.findById(id);

        if(person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody @Validated Person person) {
         HttpHeaders headers = new HttpHeaders();

         if(person == null) {
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }

         personService.savePerson(person);
         return new ResponseEntity<>(person, headers, HttpStatus.CREATED);
     }

     @PutMapping
     public ResponseEntity<Person> updateCustomer(@RequestBody @Validated Person person, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

         if(person == null) {
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }

         personService.savePerson(person);
         return new ResponseEntity<>(person, headers, HttpStatus.OK);
     }

     @DeleteMapping(value = "{id}")
     public ResponseEntity<Person> deletePerson(@PathVariable("id") Long id) {
        Person person = personService.findById(id);

         if(person == null) {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }

         personService.deleteById(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);

     }

     @GetMapping
     public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.findAll();

        if(persons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

         return new ResponseEntity<>(persons, HttpStatus.OK);
     }
}
