package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Book;
import bookShop.BookShop.model.Role;

import java.util.List;

public interface BookService {

    public Book findBookById(Long id) throws Throwable;

    public List<Book> findAll();

    public Book saveBook(Book book);

    public void deleteById(Long id);
}
