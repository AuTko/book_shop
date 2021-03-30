package bookShop.BookShop.controller;

import bookShop.BookShop.model.Stock;
import bookShop.BookShop.service.Interfaces.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/ver1/stocks/")
public class StockController {
    
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Stock> getStock(@PathVariable("id") Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Stock stock = stockService.findById(id);

        if(stock == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Stock> saveStock(@RequestBody @Validated Stock stock) {
        HttpHeaders headers = new HttpHeaders();

        if(stock == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        stockService.saveStock(stock);
        return new ResponseEntity<>(stock, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Stock> updateCustomer(@RequestBody @Validated Stock stock, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if(stock == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        stockService.saveStock(stock);
        return new ResponseEntity<>(stock, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Stock> deleteStock(@PathVariable("id") Long id) {
        Stock stock = stockService.findById(id);

        if(stock == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        stockService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.findAll();

        if(stocks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
}
