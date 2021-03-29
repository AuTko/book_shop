package bookShop.BookShop.model;

import lombok.Data;

import javax.persistence.*;

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
    private String creationDate;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Person owner;

    public Shop() {
    }

    public Shop(Long id, String shopName, String country, String city, String address,
                String description, String creationDate, Status status, Person owner) {
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
}
