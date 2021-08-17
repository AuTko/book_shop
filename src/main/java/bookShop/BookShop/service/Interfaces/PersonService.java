package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.DTO.PersonDTO;
import bookShop.BookShop.model.Person;
import bookShop.BookShop.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PersonService {

    Person findById(Long id);

    List<Person> findAll();

    public Person savePerson(PersonDTO personDTO);

    void deleteById(Long id);
}
