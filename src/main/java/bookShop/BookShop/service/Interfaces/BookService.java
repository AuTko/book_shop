package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Book;
import bookShop.BookShop.model.Role;

import java.util.List;

public interface BookService {

     Book findBookById(Long id) throws Throwable;

     List<Book> findAll();

     Book saveBook(Book book);

     void deleteById(Long id) throws Throwable;
}
