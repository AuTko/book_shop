package bookShop.BookShop.DTO;

import bookShop.BookShop.model.Review;
import lombok.Data;


@Data
public class ReviewDTO {

    private Long id;
    private String buyer; //buyer username(email)
    private String shop; //shop name
    private String comment;
    private Integer rating;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String buyer, String shop, String comment, Integer rating) {
        this.id = id;
        this.buyer = buyer;
        this.shop = shop;
        this.comment = comment;
        this.rating = rating;
    }

    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.buyer = review.getBuyer().getEmail();
        this.shop = review.getShop().getShopName();
        this.comment = review.getComment();
        this.rating = review.getRating();
    }
}
