package bookShop.BookShop.repository;

import bookShop.BookShop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByBookName(String bookName);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

    List<Book> findByBookNameAndAuthor(String bookName, String author);

    List<Book> findByBookNameAndGenre(String bookName, String genre);

    List<Book> findByAuthorAndGenre(String author, String genre);

    List<Book> findByBookNameAndAuthorAndGenre(String bookName, String author, String genre);

}
