package bookShop.BookShop.DTO;


import bookShop.BookShop.model.Shop;
import lombok.Data;

import javax.persistence.Entity;
import java.text.SimpleDateFormat;

@Data
public class ShopDTO {

    private Long id;
    private String shopName;
    private String country;
    private String city;
    private String address;
    private String description;
    private String creationDate;
    private String status; // shop status
    private String owner; // owner username(email)

    public ShopDTO() {
    }


    public ShopDTO(Long id, String shopName, String country, String city, String address, String description,
                   String creationDate, String status, String owner) {
        this.id = id;
        this.shopName = shopName;
        this.country = country;
        this.city = city;
        this.address = address;
        this.description = description;
        this.creationDate = creationDate;
        this.status = status;
        this.owner = owner;
    }

    public ShopDTO(Shop shop) {
        this.id = shop.getId();
        this.shopName = shop.getShopName();
        this.country = shop.getCountry();
        this.city = shop.getCity();
        this.address = shop.getAddress();
        this.description = shop.getDescription();
        this.creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(shop.getCreationDate());
        this.status = shop.getStatus().getDescription();
        this.owner = shop.getOwner().getEmail();
    }
}
