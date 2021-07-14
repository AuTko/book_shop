package bookShop.BookShop.DTO;

import bookShop.BookShop.model.Person;
import lombok.Data;


@Data
public class PersonDTO {

    private Long id;
    private String role; //user role
    private String firstName;
    private String lastName;
    private String email;
    //password excluded


    public PersonDTO() {
    }

    public PersonDTO(Long id, String role, String firstName, String lastName, String email) {
        this.id = id;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.role = person.getRole().getDescription();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
    }

}
