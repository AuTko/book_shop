package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Stock;

import java.util.List;

public interface StockService {

    public Stock findById(Long id);

    public List<Stock> findAll();

    public Stock saveStock(Stock stock);

    public void deleteById(Long id);
}
