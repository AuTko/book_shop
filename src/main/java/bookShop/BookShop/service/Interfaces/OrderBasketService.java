package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Order;
import bookShop.BookShop.model.OrderBasket;

import java.util.List;

public interface OrderBasketService {

    OrderBasket findById(Long id);

    List<OrderBasket> findAll();

    OrderBasket saveBasket(OrderBasket orderBasket);

    void deleteById(Long id);
}
