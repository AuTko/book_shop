package bookShop.BookShop.controller;

import bookShop.BookShop.model.Review;
import bookShop.BookShop.service.Interfaces.ReviewService;
import bookShop.BookShop.service.Interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/ver1/reviews/")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Review> getReview(@PathVariable("id") Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Review review = reviewService.findById(id);

        if(review == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> saveReview(@RequestBody @Validated Review review) {
        HttpHeaders headers = new HttpHeaders();

        if(review == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        reviewService.saveReview(review);
        return new ResponseEntity<>(review, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Review> updateCustomer(@RequestBody @Validated Review review, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if(review == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        reviewService.saveReview(review);
        return new ResponseEntity<>(review, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable("id") Long id) {
        Review review = reviewService.findById(id);

        if(review == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        reviewService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.findAll();

        if(reviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
