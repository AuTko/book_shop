package bookShop.BookShop.controller;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.Role;
import bookShop.BookShop.service.Interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/ver1/roles/")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Role> getRole(@PathVariable("id") Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Role role = roleService.findById(id);

        if(role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody @Validated Role role) {
        HttpHeaders headers = new HttpHeaders();

        if(role == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        roleService.addRole(role);

        return new ResponseEntity<>(role, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Role> updateCustomer(@RequestBody @Validated Role role, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if(role == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        roleService.addRole(role);
        return new ResponseEntity<>(role, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Role> deletePerson(@PathVariable("id") Long id) {
        Role role = roleService.findById(id);

        if(role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        roleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllPersons() {
        List<Role> roles = roleService.findAll();

        if(roles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

}
