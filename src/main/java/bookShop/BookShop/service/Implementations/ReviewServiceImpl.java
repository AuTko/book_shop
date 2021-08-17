package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.DTO.ReviewDTO;
import bookShop.BookShop.model.Review;
import bookShop.BookShop.repository.PersonRepository;
import bookShop.BookShop.repository.ReviewRepository;
import bookShop.BookShop.repository.ShopRepository;
import bookShop.BookShop.service.Interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;
    PersonRepository personRepository;
    ShopRepository shopRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, PersonRepository personRepository,
                             ShopRepository shopRepository) {
        this.reviewRepository = reviewRepository;
        this.personRepository = personRepository;
        this.shopRepository = shopRepository;
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
    public Review saveReview(ReviewDTO reviewDTO) {
        Review review = new Review(reviewDTO);
        review.setBuyer(personRepository.findByEmail(reviewDTO.getBuyer()));
        review.setShop(shopRepository.findByShopName(reviewDTO.getShop()));
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findByBuyer(Long id) {
        return reviewRepository.findByBuyer(id);
    }

    @Override
    public List<Review> findByShop(Long id) {
        return reviewRepository.findByShop(id);
    }

    @Override
    public void deleteById(Long id) {

    }
}
