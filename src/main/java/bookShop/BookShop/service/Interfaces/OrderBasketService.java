package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.DTO.OrderBasketDTO;
import bookShop.BookShop.model.Order;
import bookShop.BookShop.model.OrderBasket;

import java.util.List;

public interface OrderBasketService {

    OrderBasket findById(Long id);

    List<OrderBasket> findAll();

    OrderBasket saveBasket(OrderBasketDTO orderBasketDTO);

    void deleteById(Long id);
}
