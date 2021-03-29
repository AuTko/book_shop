package bookShop.BookShop.repository;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    //List<Role> findById(Long id);
}
