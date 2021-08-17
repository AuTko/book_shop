package bookShop.BookShop.DTO;

import bookShop.BookShop.model.Book;
import lombok.Data;

import javax.persistence.Column;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class BookDTO {

    private Long id;
    private String bookName;
    private String author;
    private String genre;
    private String publicationDate; //Date ->String
    private Integer pages;

    public BookDTO() {
    }

    public BookDTO(Long id, String bookName, String author, String genre, String publicationDate, Integer pages) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.pages = pages;
    }

    public BookDTO(Book book) {
        this.id = book.getId();
        this.bookName = book.getBookName();
        this.author = book.getAuthor();
        this.genre = book.getGenre();
        this.publicationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(book.getPublicationDate());
        this.pages = book.getPages();
    }
}


