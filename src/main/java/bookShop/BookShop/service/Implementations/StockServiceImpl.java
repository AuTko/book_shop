package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.model.Stock;
import bookShop.BookShop.repository.StockRepository;
import bookShop.BookShop.service.Interfaces.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock findById(Long id) {
        return stockRepository.findById(id).get();
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deleteById(Long id) {
        stockRepository.deleteById(id);
    }
}
