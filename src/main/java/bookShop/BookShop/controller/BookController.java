package bookShop.BookShop.controller;

import bookShop.BookShop.DTO.BookDTO;
import bookShop.BookShop.model.Book;
import bookShop.BookShop.service.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<BookDTO[]> getAllBooks() {
        //Book[] books = bookService.findAll().toArray(new Book[0]);
        BookDTO[] books = bookService.findAll().stream().map(BookDTO::new).
                toArray(BookDTO[]::new);
        //List<Wrapper> converted = original.stream().map(Wrapper::new).collect(Collectors.toList());

        if(books.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
