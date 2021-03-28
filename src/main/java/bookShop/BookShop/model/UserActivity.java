package bookShop.BookShop.model;

import lombok.Data;

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
    @JoinColumn(name = "user_id") //column name != field name
    private Person user;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Person admin;

    private String activity;

    private Date date;

    private String description;

    public UserActivity() {
    }

    public UserActivity(Long id, Person user, Person admin, String activity, Date date, String description) {
        this.id = id;
        this.user = user;
        this.admin = admin;
        this.activity = activity;
        this.date = date;
        this.description = description;
    }
}
