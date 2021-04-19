package bookShop.BookShop.controller;


import bookShop.BookShop.model.OrderBasket;
import bookShop.BookShop.service.Interfaces.OrderBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/ver1/basket/")
public class OrderBasketController {

    OrderBasketService orderBasketService;
    
    @Autowired
    public OrderBasketController(OrderBasketService orderBasketService) {
        this.orderBasketService = orderBasketService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<OrderBasket> getOrderBasket(@PathVariable("id") Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        OrderBasket orderBasket = orderBasketService.findById(id);

        if(orderBasket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orderBasket, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderBasket> saveOrderBasket(@RequestBody @Validated OrderBasket orderBasket) {
        HttpHeaders headers = new HttpHeaders();

        if(orderBasket == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        orderBasketService.saveBasket(orderBasket);
        return new ResponseEntity<>(orderBasket, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrderBasket> updateCustomer(@RequestBody @Validated OrderBasket orderBasket, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if(orderBasket == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        orderBasketService.saveBasket(orderBasket);
        return new ResponseEntity<>(orderBasket, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<OrderBasket> deleteOrderBasket(@PathVariable("id") Long id) {
        OrderBasket orderBasket = orderBasketService.findById(id);

        if(orderBasket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderBasketService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<OrderBasket>> getAllOrderBaskets() {
        List<OrderBasket> orderBaskets = orderBasketService.findAll();

        if(orderBaskets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orderBaskets, HttpStatus.OK);
    }
}
    
