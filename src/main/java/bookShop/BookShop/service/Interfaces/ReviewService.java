package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.DTO.ReviewDTO;
import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.Review;

import java.util.List;

public interface ReviewService {

    Review findById(Long id);

    List<Review> findAll();

    Review saveReview(ReviewDTO reviewDTO);

    List<Review> findByBuyer(Long id);

    List<Review> findByShop(Long id);

    void deleteById(Long id);
}
