package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Role;

import java.util.List;

public interface RoleService {

     Role findById(Long id);

     List<Role> findAll();

     Role addRole(Role role);

     void deleteById(Long id);
}
