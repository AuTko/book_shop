package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Book;
import bookShop.BookShop.model.Order;

import java.util.List;

public interface OrderService {

    public Order findById(Long id);

    public List<Order> findAll();

    public Order saveOrder(Order order);

    public void deleteById(Long id);
}
