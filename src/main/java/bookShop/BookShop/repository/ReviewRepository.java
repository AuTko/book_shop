package bookShop.BookShop.repository;

import bookShop.BookShop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByBuyer(Long id);

    List<Review> findByShop(Long id);
}
