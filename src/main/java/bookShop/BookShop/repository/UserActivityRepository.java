package bookShop.BookShop.repository;

import bookShop.BookShop.model.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
    List<UserActivity> getAllByAdmin_Id(Long id);

    List<UserActivity> getAllByUser_Id(Long id);
}
