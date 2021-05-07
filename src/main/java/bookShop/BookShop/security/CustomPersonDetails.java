package bookShop.BookShop.security;

import bookShop.BookShop.model.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomPersonDetails implements UserDetails {

    private String login;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public static CustomPersonDetails fromEntityToCustomPersonDetails(Person Entity) {
        CustomPersonDetails customPersonDetails = new CustomPersonDetails();
        customPersonDetails.login = Entity.getEmail();
        customPersonDetails.password = Entity.getPassword();
        customPersonDetails.grantedAuthorities = Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_" + Entity.getRole().getDescription()));
        return customPersonDetails;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
