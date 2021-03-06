package bookShop.BookShop.DTO;

import bookShop.BookShop.model.Order;
import lombok.Data;


@Data
public class OrderDTO {

    // in this universe shops have unique names
    private Long id;
    private String shop; //shop name
    private Long book; //book id
    private Long basket; //basket id
    private Integer amount;
    private Float totalCost;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String shop, Long book, Long basket, Integer amount, Float totalCost) {
        this.id = id;
        this.shop = shop;
        this.book = book;
        this.basket = basket;
        this.amount = amount;
        this.totalCost = totalCost;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.shop = order.getShop().getShopName();
        this.book = order.getBook().getId();
        this.basket = order.getBasket().getId();
        this.amount = order.getAmount();
        this.totalCost = order.getTotalCost();
    }
}
