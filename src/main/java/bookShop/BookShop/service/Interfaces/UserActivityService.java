package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Role;
import bookShop.BookShop.model.UserActivity;

import java.util.List;

 public interface UserActivityService {

    UserActivity findById(Long id);

     List<UserActivity> findAll();

     List<UserActivity> getAllByUserId(Long id);

     List<UserActivity> getAllByAdminId(Long id);

     UserActivity addActivity(UserActivity userActivity);

     void deleteById(Long id);
}
