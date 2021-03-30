package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.Review;

import java.util.List;

public interface ReviewService {

    public Review findById(Long id);

    public List<Review> findAll();

    public Review saveReview(Review review);

    public void deleteById(Long id);
}
