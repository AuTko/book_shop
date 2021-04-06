package bookShop.BookShop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_activity")
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) //column name != field name
    private Person user;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Person admin;

    private String activity;

    private Date date;

    private String description;

    public UserActivity() {
    }

    public UserActivity(Person user, Person admin, String activity, Date date, String description) {
        this.user = user;
        this.admin = admin;
        this.activity = activity;
        this.date = date;
        this.description = description;
    }
}
