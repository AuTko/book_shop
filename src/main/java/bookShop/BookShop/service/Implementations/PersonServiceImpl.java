package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.DTO.PersonDTO;
import bookShop.BookShop.model.Person;
import bookShop.BookShop.repository.PersonRepository;
import bookShop.BookShop.repository.RoleRepository;
import bookShop.BookShop.service.Interfaces.PersonService;
import bookShop.BookShop.service.Interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // ≈ Component
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, RoleService roleService, RoleRepository roleRepository) {

        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
    }

    //Basically getOne is a lazy load operation. Thus you get only a reference (a proxy) to the entity.
    // That means no DB access is actually made.
    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person savePerson(PersonDTO personDTO) {

        Person person = new Person(personDTO);
        person.setRole(roleRepository.findByDescription(personDTO.getRole()));

        return personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
