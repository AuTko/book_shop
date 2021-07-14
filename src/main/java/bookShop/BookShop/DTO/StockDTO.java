package bookShop.BookShop.DTO;


import bookShop.BookShop.model.Stock;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class StockDTO {

    private Long id;
    private String shop;  // shop name
    private String book; // book name
    private String status; // status description
    private Integer amount;
    private Float bookPrice;
    private String creationDate; //Date -> String

    public StockDTO(){}

    public StockDTO(Long id, String shop, String book, String status, Integer amount,
                    Float bookPrice, String creationDate) {
        this.id = id;
        this.shop = shop;
        this.book = book;
        this.status = status;
        this.amount = amount;
        this.bookPrice = bookPrice;
        this.creationDate = creationDate;
    }

    public StockDTO(Stock stock) {
        this.id = stock.getId();
        this.shop = stock.getShop().getShopName();
        this.book = stock.getBook().getBookName();
        this.status = stock.getStatus().getDescription();
        this.amount = stock.getAmount();
        this.bookPrice = stock.getBookPrice();
        this.creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(stock.getCreationDate());
    }
}
