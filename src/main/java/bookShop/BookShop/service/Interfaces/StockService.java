package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Stock;

import java.util.List;

 public interface StockService {

     Stock findById(Long id);

     List<Stock> findAll();

     Stock saveStock(Stock stock);

     void deleteById(Long id);
}
