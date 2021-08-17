package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.DTO.StockDTO;
import bookShop.BookShop.model.Stock;
import bookShop.BookShop.repository.BookRepository;
import bookShop.BookShop.repository.ShopRepository;
import bookShop.BookShop.repository.StatusRepository;
import bookShop.BookShop.repository.StockRepository;
import bookShop.BookShop.service.Interfaces.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final BookRepository bookRepository;
    private final ShopRepository shopRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository, BookRepository bookRepository,
                            ShopRepository shopRepository, StatusRepository statusRepository) {
        this.stockRepository = stockRepository;
        this.bookRepository = bookRepository;
        this.shopRepository = shopRepository;
        this.statusRepository = statusRepository;
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
    public List<Stock> findByShop(String shopName) {

        return stockRepository.findByShop(shopRepository.findByShopName(shopName).getId());
    }

    @Override
    public Stock saveStock(StockDTO stockDTO) {

        Stock stock = new Stock(stockDTO);
        stock.setBook(bookRepository.findById(stockDTO.getBook()).get());
        stock.setShop(shopRepository.findByShopName(stockDTO.getShop()));
        // group 2 - stock statuses
        stock.setStatus(statusRepository.findByGroupAndDescription(2L, stockDTO.getStatus()));

        return stockRepository.save(stock);

    }

    @Override
    public void deleteById(Long id) {
        stockRepository.deleteById(id);
    }
}
