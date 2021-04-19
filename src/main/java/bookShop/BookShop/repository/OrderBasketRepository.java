package bookShop.BookShop.repository;

import bookShop.BookShop.model.OrderBasket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBasketRepository extends JpaRepository<OrderBasket, Long> {
}
