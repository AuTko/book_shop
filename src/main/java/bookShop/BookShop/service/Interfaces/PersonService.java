package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PersonService {

    public Person findById(Long id);

    public List<Person> findAll();

    public Person savePerson(Person person);

    public void deleteById(Long id);
}
