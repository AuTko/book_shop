package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Role;
import bookShop.BookShop.model.UserActivity;

import java.util.List;

public interface UserActivityService {

    public UserActivity findById(Long id);

    public List<UserActivity> findAll();

    public List<UserActivity> getAllByUserId(Long id);

    public List<UserActivity> getAllByAdminId(Long id);

    public UserActivity addActivity(UserActivity userActivity);

    public void deleteById(Long id);
}
