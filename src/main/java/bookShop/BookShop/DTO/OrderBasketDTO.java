package bookShop.BookShop.DTO;

import bookShop.BookShop.model.OrderBasket;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class OrderBasketDTO {

    private Long id;
    private String person; //person email(username)
    private String status; // order status
    private Float totalCost;
    private String deliveryAddress;
    private String description;
    private String submitDate;  //Date ->String
    private String completeDate; //Date ->String

    public OrderBasketDTO() {
    }

    public OrderBasketDTO(Long id, String person, String status, Float totalCost, String deliveryAddress,
                          String description, String submitDate, String completeDate) {
        this.id = id;
        this.person = person;
        this.status = status;
        this.totalCost = totalCost;
        this.deliveryAddress = deliveryAddress;
        this.description = description;
        this.submitDate = submitDate;
        this.completeDate = completeDate;
    }

    public OrderBasketDTO(OrderBasket orderBasket) {
        this.id = orderBasket.getId();
        this.person = orderBasket.getPerson().getEmail();
        this.status = orderBasket.getStatus().getDescription();
        this.totalCost = orderBasket.getTotalCost();
        this.deliveryAddress = orderBasket.getDeliveryAddress();
        this.description = orderBasket.getDescription();
        this.submitDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderBasket.getSubmitDate());
        this.completeDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderBasket.getCompleteDate());
    }
}
