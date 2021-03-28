package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Role;

import java.util.List;

public interface RoleService {

    public Role findById(Long id);

    public List<Role> findAll();

    public Role addRole(Role role);

    public void deleteById(Long id);
}
