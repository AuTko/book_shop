package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.model.Review;
import bookShop.BookShop.repository.ReviewRepository;
import bookShop.BookShop.service.Interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review saveReview(Review review) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
