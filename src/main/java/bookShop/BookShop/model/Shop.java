package bookShop.BookShop.model;

import bookShop.BookShop.DTO.ShopDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop")
    private String shopName;

    private String country;

    private String city;

    private String address;

    private String description;

    @Column(name = "creation_date")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Person owner;

    public Shop() {
    }

    public Shop(String shopName, String country, String city, String address, String description, Date creationDate,
                Status status, Person owner) {

        this.shopName = shopName;
        this.country = country;
        this.city = city;
        this.address = address;
        this.description = description;
        this.creationDate = creationDate;
        this.status = status;
        this.owner = owner;
    }

    public Shop(ShopDTO shopDTO) {

        this.id = shopDTO.getId();
        this.shopName = shopDTO.getShopName();
        this.country = shopDTO.getCountry();
        this.city = shopDTO.getCity();
        this.address = shopDTO.getAddress();
        this.description = shopDTO.getDescription();
        try {
            this.creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(shopDTO.getCreationDate());
        } catch (java.text.ParseException e) {
            e.getMessage();
        }
    }
}
