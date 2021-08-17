package bookShop.BookShop.repository;

import bookShop.BookShop.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findByShop(Long shop);
}
