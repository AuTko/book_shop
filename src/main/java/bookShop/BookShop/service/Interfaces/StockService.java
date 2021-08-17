package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.DTO.StockDTO;
import bookShop.BookShop.model.Stock;

import java.util.List;

public interface StockService {

    Stock findById(Long id);

    List<Stock> findAll();

    List<Stock> findByShop(String shopName);

    Stock saveStock(StockDTO stockDTO);


    void deleteById(Long id);
}
