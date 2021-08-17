package bookShop.BookShop.controller;

import bookShop.BookShop.DTO.PersonDTO;
import bookShop.BookShop.DTO.ReviewDTO;
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
    public ResponseEntity<ReviewDTO> getReview(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ReviewDTO reviewDTO = new ReviewDTO(reviewService.findById(id));

        if (reviewDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reviewDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> saveReview(@RequestBody @Validated ReviewDTO reviewDTO) {
        HttpHeaders headers = new HttpHeaders();

        if (reviewDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        reviewService.saveReview(reviewDTO);
        return new ResponseEntity<>(reviewDTO, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ReviewDTO> updateReview(@RequestBody @Validated ReviewDTO reviewDTO, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (reviewDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        reviewService.saveReview(reviewDTO);
        return new ResponseEntity<>(reviewDTO, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<ReviewDTO> deleteReview(@PathVariable("id") Long id) {
        ReviewDTO reviewDTO = new ReviewDTO(reviewService.findById(id));

        if (reviewDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        reviewService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<ReviewDTO[]> getAllReviews() {
        ReviewDTO[] reviewDTOS = reviewService.findAll().stream().map(ReviewDTO::new).
                toArray(ReviewDTO[]::new);

        if (reviewDTOS.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reviewDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/buyer/{id}")
    public ResponseEntity<ReviewDTO[]> getReviewsByBuyer(@PathVariable("id") Long id) {
        ReviewDTO[] reviewDTOS = reviewService.findByBuyer(id).stream().map(ReviewDTO::new).
                toArray(ReviewDTO[]::new);

        if (reviewDTOS.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reviewDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/shop/{id}")
    public ResponseEntity<ReviewDTO[]> getReviewsByShop(@PathVariable("id") Long id) {
        ReviewDTO[] reviewDTOS = reviewService.findByShop(id).stream().map(ReviewDTO::new).
                toArray(ReviewDTO[]::new);

        if (reviewDTOS.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reviewDTOS, HttpStatus.OK);
    }
}
