package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PersonService {

     Person findById(Long id);

     List<Person> findAll();

     Person savePerson(Person person);

     void deleteById(Long id);

     Person findByLogin(String login);

     Person findByLoginAndPassword(String login, String password);
}
