package bookShop.BookShop.model;

import bookShop.BookShop.DTO.PersonDTO;
import bookShop.BookShop.repository.RoleRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data //(Lombok) A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, @Setter on all non-final fields,
// and @RequiredArgsConstructor (init all final fields)
@Entity
@Table(name = "person") //table name != class name
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false) //column name != field name
    private Role role;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    public Person() {
    }

    public Person(Role role, String firstName, String lastName, String email, String password) {

        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Person(PersonDTO personDTO) {
        this.id = personDTO.getId();
        this.firstName = personDTO.getFirstName();
        this.lastName = personDTO.getLastName();
        this.email = personDTO.getEmail();
        this.password = personDTO.getEmail();
    }
}
