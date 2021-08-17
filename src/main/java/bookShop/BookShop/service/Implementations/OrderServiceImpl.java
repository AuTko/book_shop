package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.DTO.OrderDTO;
import bookShop.BookShop.model.Order;
import bookShop.BookShop.repository.BookRepository;
import bookShop.BookShop.repository.OrderBasketRepository;
import bookShop.BookShop.repository.OrderRepository;
import bookShop.BookShop.repository.ShopRepository;
import bookShop.BookShop.service.Interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ShopRepository shopRepository;
    private final BookRepository bookRepository;
    private final OrderBasketRepository orderBasketRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ShopRepository shopRepository,
                            BookRepository bookRepository, OrderBasketRepository orderBasketRepository) {
        this.orderRepository = orderRepository;
        this.shopRepository = shopRepository;
        this.bookRepository = bookRepository;
        this.orderBasketRepository = orderBasketRepository;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(OrderDTO orderDTO) {

        Order order = new Order(orderDTO);
        order.setShop(shopRepository.findByShopName(orderDTO.getShop()));
        order.setBook(bookRepository.findById(orderDTO.getBook()).get());
        order.setBasket(orderBasketRepository.findById(orderDTO.getBasket()).get());

        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
