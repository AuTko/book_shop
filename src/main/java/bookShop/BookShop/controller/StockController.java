package bookShop.BookShop.controller;

import bookShop.BookShop.DTO.ShopDTO;
import bookShop.BookShop.DTO.StockDTO;
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
    public ResponseEntity<StockDTO> getStock(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        StockDTO stockDTO = new StockDTO(stockService.findById(id));

        if (stockDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(stockDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StockDTO> saveStock(@RequestBody @Validated StockDTO stockDTO) {
        HttpHeaders headers = new HttpHeaders();

        if (stockDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        stockService.saveStock(stockDTO);

        return new ResponseEntity<>(stockDTO, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StockDTO> updateStock(@RequestBody @Validated StockDTO stockDTO, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (stockDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        stockService.saveStock(stockDTO);

        return new ResponseEntity<>(stockDTO, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<StockDTO> deleteStock(@PathVariable("id") Long id) {

        StockDTO stockDTO = new StockDTO(stockService.findById(id));

        if (stockDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        stockService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<StockDTO[]> getAllStocks() {

        StockDTO[] stockDTOS = stockService.findAll().stream().map(StockDTO::new).
                toArray(StockDTO[]::new);

        if (stockDTOS.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(stockDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "shop/{shopName}")
    public ResponseEntity<StockDTO[]> getAllStocksByShopName(@PathVariable("shopName") String shopName) {

        StockDTO[] stockDTOS = stockService.findByShop(shopName).stream().map(StockDTO::new).
                toArray(StockDTO[]::new);

        if (stockDTOS.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(stockDTOS, HttpStatus.OK);
    }
}
