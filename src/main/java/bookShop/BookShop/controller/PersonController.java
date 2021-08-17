package bookShop.BookShop.controller;

import bookShop.BookShop.DTO.BookDTO;
import bookShop.BookShop.DTO.PersonDTO;
import bookShop.BookShop.model.Person;
import bookShop.BookShop.service.Interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PersonDTO person = new PersonDTO(personService.findById(id));

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> savePerson(@RequestBody @Validated PersonDTO personDTO) {
        HttpHeaders headers = new HttpHeaders();

        if (personDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        personService.savePerson(personDTO);
        return new ResponseEntity<>(personDTO, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody @Validated PersonDTO personDTO,
                                                  UriComponentsBuilder builder) {

        HttpHeaders headers = new HttpHeaders();

        if (personDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        personService.savePerson(personDTO);
        return new ResponseEntity<>(personDTO, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<PersonDTO> deletePerson(@PathVariable("id") Long id) {
        PersonDTO personDTO = new PersonDTO(personService.findById(id));

        if (personDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<PersonDTO[]> getAllPersons() {
        PersonDTO[] persons = personService.findAll().stream().map(PersonDTO::new).
                toArray(PersonDTO[]::new);

        if (persons.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
