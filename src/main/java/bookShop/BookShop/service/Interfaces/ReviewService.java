package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.Review;

import java.util.List;

public interface ReviewService {

     Review findById(Long id);

     List<Review> findAll();

     Review saveReview(Review review);

     void deleteById(Long id);
}
