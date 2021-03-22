package bookShop.BookShop.model;

import lombok.Data;

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
    @JoinColumn(name = "role_id") //column name != field name
    private Role role;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


}
