package bookShop.BookShop.model;

import bookShop.BookShop.DTO.OrderBasketDTO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@Table(name = "order_basket")

public class OrderBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @Column(name = "total_cost")
    private Float totalCost;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    private String description;

    @Column(name = "submit_date")
    private Date submitDate;

    @Column(name = "complete_date")
    private Date completeDate;

    public OrderBasket() {
    }

    public OrderBasket(Person person, Status status, Float totalCost, String deliveryAddress, String description,
                       Date submitDate, Date completeDate) {
        this.person = person;
        this.status = status;
        this.totalCost = totalCost;
        this.deliveryAddress = deliveryAddress;
        this.description = description;
        this.submitDate = submitDate;
        this.completeDate = completeDate;
    }

    public OrderBasket(OrderBasketDTO orderBasketDTO) {

        this.id = orderBasketDTO.getId();
        this.totalCost = orderBasketDTO.getTotalCost();
        this.deliveryAddress = orderBasketDTO.getDeliveryAddress();
        this.description = orderBasketDTO.getDescription();
        try {
            this.submitDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(orderBasketDTO.getSubmitDate());
            this.completeDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(orderBasketDTO.getCompleteDate());
        } catch (java.text.ParseException e) {
            e.getMessage();
        }
    }
}
