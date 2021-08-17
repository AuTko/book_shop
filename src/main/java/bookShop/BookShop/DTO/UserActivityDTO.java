package bookShop.BookShop.DTO;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.Status;
import bookShop.BookShop.model.UserActivity;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class UserActivityDTO {

    private Long id;
    private String user; // user username(email)
    private String admin; // admin username(email)
    private String activity;
    private String date;
    private String description;

    public UserActivityDTO() {
    }

    public UserActivityDTO(Long id, String user, String admin, String activity, String date, String description) {
        this.id = id;
        this.user = user;
        this.admin = admin;
        this.activity = activity;
        this.date = date;
        this.description = description;
    }

    public UserActivityDTO(UserActivity userActivity) {
        this.id = userActivity.getId();
        this.user = userActivity.getUser().getEmail();
        this.admin = userActivity.getAdmin().getEmail();
        this.activity = userActivity.getActivity().getDescription();
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(userActivity.getDate());
        this.description = userActivity.getDescription();
    }
}
