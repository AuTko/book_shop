package bookShop.BookShop.controller;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.Role;
import bookShop.BookShop.security.AuthRequest;
import bookShop.BookShop.security.AuthResponse;
import bookShop.BookShop.security.JwtProvider;
import bookShop.BookShop.service.Interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/ver1/")
public class AuthController {

    private final PersonService personService;
    private final JwtProvider jwtProvider;

    @Autowired
    public AuthController(PersonService personService, JwtProvider jwtProvider) {
        this.personService = personService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody @Validated Person person) {
        personService.savePerson(person);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        Person personEntity = personService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(personEntity.getEmail());
        return new AuthResponse(token);
    }
}
