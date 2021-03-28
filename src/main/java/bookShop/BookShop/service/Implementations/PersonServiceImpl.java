package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.repository.PersonRepository;
import bookShop.BookShop.service.Interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // ≈ Component
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
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
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
