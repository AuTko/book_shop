package bookShop.BookShop.model;

import bookShop.BookShop.DTO.BookDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    public Book(BookDTO bookDTO) {
        this.id = bookDTO.getId();
        this.bookName = bookDTO.getBookName();
        this.author = bookDTO.getAuthor();
        this.genre = bookDTO.getGenre();
        try {
            this.publicationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bookDTO.getPublicationDate());
        } catch (java.text.ParseException e) {
            e.getMessage();
        }
        this.pages = bookDTO.getPages();
    }

}
