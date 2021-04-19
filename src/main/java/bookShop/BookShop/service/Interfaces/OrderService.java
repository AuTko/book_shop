package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Book;
import bookShop.BookShop.model.Order;

import java.util.List;

public interface OrderService {

     Order findById(Long id);

     List<Order> findAll();

     Order saveOrder(Order order);

     void deleteById(Long id);
}
