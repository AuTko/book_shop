package bookShop.BookShop.security;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.service.Interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomPersonDetailsService implements UserDetailsService {

    @Autowired
    private PersonService personService;


    @Override
    public CustomPersonDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personService.findByLogin(username);
        return CustomPersonDetails.fromEntityToCustomPersonDetails(person);
    }
}
