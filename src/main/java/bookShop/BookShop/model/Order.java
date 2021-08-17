package bookShop.BookShop.model;

import bookShop.BookShop.DTO.OrderDTO;
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
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "basket_id", nullable = false)
    private OrderBasket basket;

    private Integer amount;

    @Column(name = "total_cost")
    private Float totalCost;

    public Order() {
    }

    public Order(Shop shop, Book book, OrderBasket basket, Integer amount, Float totalCost) {
        this.shop = shop;
        this.book = book;
        this.basket = basket;
        this.amount = amount;
        this.totalCost = totalCost;
    }

    public Order(OrderDTO orderDTO) {
        this.id = orderDTO.getId();
        this.amount = orderDTO.getAmount();
        this.totalCost = orderDTO.getTotalCost();
    }
}
