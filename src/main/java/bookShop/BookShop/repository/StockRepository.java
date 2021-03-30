package bookShop.BookShop.repository;

import bookShop.BookShop.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
