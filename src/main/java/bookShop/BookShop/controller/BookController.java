package bookShop.BookShop.controller;

import bookShop.BookShop.model.Book;
import bookShop.BookShop.service.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/ver1/books/")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) throws Throwable {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Book book = bookService.findBookById(id);

        if(book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody @Validated Book book) {
        HttpHeaders headers = new HttpHeaders();

        if(book == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        bookService.saveBook(book);
        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody @Validated Book book, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if(book == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        bookService.saveBook(book);
        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Long id) throws Throwable {
        Book book = bookService.findBookById(id);

        if(book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAll();

        if(books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
