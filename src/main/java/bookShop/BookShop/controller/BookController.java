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
    public ResponseEntity<BookDTO> getBook(@PathVariable("id") Long id) throws Throwable {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        BookDTO book = new BookDTO(bookService.findBookById(id));

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> saveBook(@RequestBody @Validated BookDTO bookDTO) {
        HttpHeaders headers = new HttpHeaders();

        if (bookDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        bookService.saveBook(bookDTO);
        return new ResponseEntity<>(bookDTO, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BookDTO> updateBook(@RequestBody @Validated BookDTO bookDTO,
                                              UriComponentsBuilder builder) throws Throwable {
        HttpHeaders headers = new HttpHeaders();

        if (bookDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        bookService.saveBook(bookDTO);
        return new ResponseEntity<>(bookDTO, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable("id") Long id) throws Throwable {
        BookDTO bookDTO = new BookDTO(bookService.findBookById(id));

        if (bookDTO == null) {
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

        if (books.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }


    @GetMapping(value = "{bookName}/{author}/{genre}")
    public ResponseEntity<BookDTO[]> getBooksByParameters(@PathVariable("bookName") String bookName,
                                                          @PathVariable("author") String author,
                                                          @PathVariable("genre") String genre) {

        //Book[] books = bookService.findAll().toArray(new Book[0]);
        BookDTO[] books = bookService.findBooksByParameters(bookName, author, genre).stream().map(BookDTO::new).
                toArray(BookDTO[]::new);
        //List<Wrapper> converted = original.stream().map(Wrapper::new).collect(Collectors.toList());

        if (books.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
