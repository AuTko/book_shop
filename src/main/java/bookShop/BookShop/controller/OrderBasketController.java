package bookShop.BookShop.controller;


import bookShop.BookShop.DTO.BookDTO;
import bookShop.BookShop.DTO.OrderBasketDTO;
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
    public ResponseEntity<OrderBasketDTO> getOrderBasket(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        OrderBasketDTO OrderBasketDTO = new OrderBasketDTO(orderBasketService.findById(id));

        if (OrderBasketDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(OrderBasketDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderBasketDTO> saveOrderBasket(@RequestBody @Validated OrderBasketDTO orderBasketDTO) {
        HttpHeaders headers = new HttpHeaders();

        if (orderBasketDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        orderBasketService.saveBasket(orderBasketDTO);

        return new ResponseEntity<>(orderBasketDTO, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrderBasketDTO> updateCustomer(@RequestBody @Validated OrderBasketDTO orderBasketDTO, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (orderBasketDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        orderBasketService.saveBasket(orderBasketDTO);
        return new ResponseEntity<>(orderBasketDTO, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<OrderBasketDTO> deleteOrderBasket(@PathVariable("id") Long id) {
        OrderBasketDTO orderBasketDTO = new OrderBasketDTO(orderBasketService.findById(id));

        if (orderBasketDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderBasketService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<OrderBasketDTO[]> getAllOrderBaskets() {
        OrderBasketDTO[] orderBasketDTOs = orderBasketService.findAll().stream().map(OrderBasketDTO::new).
                toArray(OrderBasketDTO[]::new);
        //List<Wrapper> converted = original.stream().map(Wrapper::new).collect(Collectors.toList());

        if (orderBasketDTOs.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orderBasketDTOs, HttpStatus.OK);
    }
}
    
