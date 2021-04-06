package bookShop.BookShop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book")
    private String bookName;

    private String author;

    private String genre;

    @Column(name = "publication_date")
    private Date publicationDate;

    private Integer pages;

    public Book() {
    }

    public Book(String bookName, String author, String genre, Date publicationDate, Integer pages) {
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.pages = pages;
    }
}
