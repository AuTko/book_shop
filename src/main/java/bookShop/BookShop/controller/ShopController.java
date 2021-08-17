package bookShop.BookShop.controller;

import bookShop.BookShop.DTO.ReviewDTO;
import bookShop.BookShop.DTO.ShopDTO;
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
    public ResponseEntity<ShopDTO> getShop(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ShopDTO shopDTO = new ShopDTO(shopService.findById(id));

        if (shopDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(shopDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShopDTO> saveShop(@RequestBody @Validated ShopDTO shopDTO) {
        HttpHeaders headers = new HttpHeaders();

        if (shopDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        shopService.saveShop(shopDTO);

        return new ResponseEntity<>(shopDTO, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ShopDTO> updateShop(@RequestBody @Validated ShopDTO shopDTO, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (shopDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        shopService.saveShop(shopDTO);

        return new ResponseEntity<>(shopDTO, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<ShopDTO> deleteShop(@PathVariable("id") Long id) {

        ShopDTO shopDTO = new ShopDTO(shopService.findById(id));

        if (shopDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        shopService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<ShopDTO[]> getAllShops() {

        ShopDTO[] shopDTOS = shopService.findAll().stream().map(ShopDTO::new).
                toArray(ShopDTO[]::new);

        if (shopDTOS.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(shopDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "owner/{email}")
    public ResponseEntity<ShopDTO[]> getShopsByOwner(@PathVariable("email") String email) {

        ShopDTO[] shopDTOS = shopService.findByOwner(email).stream().map(ShopDTO::new).
                toArray(ShopDTO[]::new);

        if (shopDTOS.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(shopDTOS, HttpStatus.OK);
    }
}
