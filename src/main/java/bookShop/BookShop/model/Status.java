package bookShop.BookShop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "statuses")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String group;
    // group 1 - shop statuses
    // group 2 - stock statuses
    // group 3 - orderBasket statuses
    // group 4 - user activity statuses

    private String description;

    public Status() {
    }

    public Status(String group, String description) {
        this.group = group;
        this.description = description;
    }
}
