package bookShop.BookShop.repository;

import bookShop.BookShop.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * repository interface for Person class
 * needed for requests generating
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
  //  List<Person> findByLastName(String lastName);
}
