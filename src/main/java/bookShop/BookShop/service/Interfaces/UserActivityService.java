package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.DTO.UserActivityDTO;
import bookShop.BookShop.model.Role;
import bookShop.BookShop.model.UserActivity;

import java.util.List;

public interface UserActivityService {

    UserActivity findById(Long id);

    List<UserActivity> findAll();

    List<UserActivity> getAllByUser(String email);

    List<UserActivity> getAllByAdmin(String email);

    UserActivity addActivity(UserActivityDTO userActivityDTO);

    void deleteById(Long id);
}
