package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.DTO.BookDTO;
import bookShop.BookShop.model.Book;
import bookShop.BookShop.model.Role;

import java.util.List;

public interface BookService {

    Book findBookById(Long id) throws Throwable;

    List<Book> findAll();

    Book saveBook(BookDTO bookDTO);

    void deleteById(Long id) throws Throwable;

    List<Book> findBooksByParameters(String bookName, String author, String genre);
}
