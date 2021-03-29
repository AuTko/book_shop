package bookShop.BookShop.controller;

import bookShop.BookShop.model.Shop;
import bookShop.BookShop.service.Interfaces.ShopService;
import bookShop.BookShop.service.Interfaces.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/ver1/shops/")
public class ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Shop> getShop(@PathVariable("id") Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Shop shop = shopService.findById(id);

        if(shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Shop> saveShop(@RequestBody @Validated Shop shop) {
        HttpHeaders headers = new HttpHeaders();

        if(shop == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        shopService.saveShop(shop);
        return new ResponseEntity<>(shop, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Shop> updateShop(@RequestBody @Validated Shop shop, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if(shop == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        shopService.saveShop(shop);
        return new ResponseEntity<>(shop, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Shop> deleteShop(@PathVariable("id") Long id) {
        Shop shop = shopService.findById(id);

        if(shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        shopService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<Shop>> getAllShops() {
        List<Shop> persons = shopService.findAll();

        if(persons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
