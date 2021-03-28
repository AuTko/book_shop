package bookShop.BookShop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    public Role() {
    }

    public Role(long id, String description) {
        this.id = id;
        this.description = description;
    }
}
