package bookShop.BookShop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private Person buyer;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    private String comment;

    private Integer rating;

    public Review() {
    }

    public Review(Person buyer, Shop shop, String comment, Integer rating) {
        this.buyer = buyer;
        this.shop = shop;
        this.comment = comment;
        this.rating = rating;
    }
}
