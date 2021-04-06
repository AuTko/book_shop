package bookShop.BookShop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    private Integer amount;

    @Column(name = "price_per_item")
    private Float bookPrice;

    @Column(name = "creation_date")
    private Date creationDate;

    public Stock() {
    }

    public Stock(Shop shop, Book book, Status status, Integer amount, Float bookPrice, Date creationDate) {
        this.shop = shop;
        this.book = book;
        this.status = status;
        this.amount = amount;
        this.bookPrice = bookPrice;
        this.creationDate = creationDate;
    }
}
