package bookShop.BookShop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Person buyer;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    private String comment;

    private Integer rating;

    public Review() {
    }

    public Review(Long id, Person buyer, Shop shop, String comment, Integer rating) {
        this.id = id;
        this.buyer = buyer;
        this.shop = shop;
        this.comment = comment;
        this.rating = rating;
    }
}
