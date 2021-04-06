package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.exception.NotFoundDataForIdException;
import bookShop.BookShop.model.Book;
import bookShop.BookShop.repository.BookRepository;
import bookShop.BookShop.service.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findBookById(Long id) throws Throwable {
        return bookRepository.findBookById(id).orElseThrow(() ->
                new NotFoundDataForIdException("Book by id " + id + " was not found to show"));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
