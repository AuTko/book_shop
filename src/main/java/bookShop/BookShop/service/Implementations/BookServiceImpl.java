package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.DTO.BookDTO;
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
        return bookRepository.findById(id).orElseThrow(() ->
                new NotFoundDataForIdException("Book by id " + id + " was not found to show"));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(BookDTO bookDTO) {
        return bookRepository.save(new Book(bookDTO));
    }

    @Override
    public void deleteById(Long id) throws Throwable {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findBooksByParameters(String bookName, String author, String genre) {
        if (!bookName.equals("null") && author.equals("null") && genre.equals("null")) {
            return bookRepository.findByBookName(bookName);
        }
        if (bookName.equals("null") && !author.equals("null") && genre.equals("null")) {
            return bookRepository.findByAuthor(author);
        }
        if (bookName.equals("null") && author.equals("null") && !genre.equals("null")) {
            return bookRepository.findByGenre(genre);
        }
        if (!bookName.equals("null") && !author.equals("null") && genre.equals("null")) {
            return bookRepository.findByBookNameAndAuthor(bookName, author);
        }
        if (!bookName.equals("null") && author.equals("null") && !genre.equals("null")) {
            return bookRepository.findByBookNameAndGenre(bookName, genre);
        }
        if (bookName.equals("null") && !author.equals("null") && !genre.equals("null")) {
            return bookRepository.findByAuthorAndGenre(author, genre);
        }
        if (!bookName.equals("null") && !author.equals("null") && !genre.equals("null")) {
            return bookRepository.findByAuthorAndGenre(author, genre);
        }

        return bookRepository.findByBookNameAndAuthorAndGenre(bookName, author, genre);

    }
}
