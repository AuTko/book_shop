package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.repository.PersonRepository;
import bookShop.BookShop.service.Interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // ≈ Component
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public Person savePerson(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        return personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person findByLogin(String login) {
        return personRepository.findByEmail(login);
    }

    @Override
    public Person findByLoginAndPassword(String login, String password) {
        Person person = findByLogin(login);
        if(person != null) {
            if (passwordEncoder.matches(password, person.getPassword())) {
                return person;
            }
        }
        return null;
    }
}
