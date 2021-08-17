package bookShop.BookShop.model;

import bookShop.BookShop.DTO.UserActivityDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.text.SimpleDateFormat;
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

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Status activity;

    private Date date;

    private String description;

    public UserActivity() {
    }

    public UserActivity(Person user, Person admin, Status activity, Date date, String description) {
        this.user = user;
        this.admin = admin;
        this.activity = activity;
        this.date = date;
        this.description = description;
    }

    public UserActivity(UserActivityDTO userActivityDTO) {
        this.id = userActivityDTO.getId();
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(userActivityDTO.getDate());
        } catch (java.text.ParseException e) {
            e.getMessage();
        }
        this.description = userActivityDTO.getDescription();
    }
}
