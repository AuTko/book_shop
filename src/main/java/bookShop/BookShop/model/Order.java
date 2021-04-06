package bookShop.BookShop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private Person person;

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

    @Column(name = "total_cost")
    private Float totalCost;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    private String description;

    @Column(name = "submit_date")
    private Date submitDate;

    @Column(name = "complete_date")
    private Date completeDate;

    public Order() {
    }

    public Order(Person person, Shop shop, Book book, Status status, Integer amount,
                 Float totalCost, String deliveryAddress, String description, Date submitDate, Date completeDate) {
        this.person = person;
        this.shop = shop;
        this.book = book;
        this.status = status;
        this.amount = amount;
        this.totalCost = totalCost;
        this.deliveryAddress = deliveryAddress;
        this.description = description;
        this.submitDate = submitDate;
        this.completeDate = completeDate;
    }
}
