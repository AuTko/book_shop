package bookShop.BookShop.controller;

import bookShop.BookShop.DTO.OrderBasketDTO;
import bookShop.BookShop.DTO.OrderDTO;
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
    public ResponseEntity<OrderDTO> getOrder(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        OrderDTO orderDTO = new OrderDTO(orderService.findById(id));

        if (orderDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody @Validated OrderDTO orderDTO) {
        HttpHeaders headers = new HttpHeaders();

        if (orderDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        orderService.saveOrder(orderDTO);

        return new ResponseEntity<>(orderDTO, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody @Validated OrderDTO orderDTO, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (orderDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        orderService.saveOrder(orderDTO);
        return new ResponseEntity<>(orderDTO, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable("id") Long id) {
        OrderDTO orderDTO = new OrderDTO(orderService.findById(id));

        if (orderDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<OrderDTO[]> getAllOrders() {

        OrderDTO[] orderDTOs = orderService.findAll().stream().map(OrderDTO::new).
                toArray(OrderDTO[]::new);

        if (orderDTOs.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orderDTOs, HttpStatus.OK);
    }
}
