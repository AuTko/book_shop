package bookShop.BookShop.model;

import lombok.Data;


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
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne
    @Column(name = "book_id")
    private Book book;

    @ManyToOne
    @Column(name = "status_id")
    private Status status;

    private Integer amount;

    @Column(name = "price_per_item")
    private Float bookPrice;

    @Column(name = "creation_date")
    private Date creationDate;

    public Stock() {
    }

    public Stock(Long id, Shop shop, Book book, Status status, Integer amount, Float bookPrice, Date creationDate) {
        this.id = id;
        this.shop = shop;
        this.book = book;
        this.status = status;
        this.amount = amount;
        this.bookPrice = bookPrice;
        this.creationDate = creationDate;
    }
}
