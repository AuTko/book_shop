package bookShop.BookShop.controller;

import bookShop.BookShop.model.Order;
import bookShop.BookShop.service.Interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/ver1/orders/")
public class OrderController {
    
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Order order = orderService.findById(id);

        if(order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody @Validated Order order) {
        HttpHeaders headers = new HttpHeaders();

        if(order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        orderService.saveOrder(order);
        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Order> updateCustomer(@RequestBody @Validated Order order, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if(order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        orderService.saveOrder(order);
        return new ResponseEntity<>(order, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable("id") Long id) {
        Order order = orderService.findById(id);

        if(order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.findAll();

        if(orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
