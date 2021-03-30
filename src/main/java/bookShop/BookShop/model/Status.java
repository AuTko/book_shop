package bookShop.BookShop.model;

import lombok.Data;

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
    // group 3 - order service

    private String description;

    public Status() {
    }

    public Status(Long id, String group, String description) {
        this.id = id;
        this.group = group;
        this.description = description;
    }
}
