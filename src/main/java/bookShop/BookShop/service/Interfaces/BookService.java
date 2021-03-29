package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Book;
import bookShop.BookShop.model.Role;

import java.util.List;

public interface BookService {

    public Book findById(Long id);

    public List<Book> findAll();

    public Book saveBook(Book book);

    public void deleteById(Long id);
}
