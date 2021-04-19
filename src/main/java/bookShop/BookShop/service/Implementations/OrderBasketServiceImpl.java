package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.model.OrderBasket;
import bookShop.BookShop.repository.OrderBasketRepository;
import bookShop.BookShop.service.Interfaces.OrderBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBasketServiceImpl implements OrderBasketService {

    private final OrderBasketRepository orderBasketRepository;

    @Autowired
    public OrderBasketServiceImpl(OrderBasketRepository orderBasketRepository) {
        this.orderBasketRepository = orderBasketRepository;
    }

    @Override
    public OrderBasket findById(Long id) {
        return orderBasketRepository.findById(id).get();
    }

    @Override
    public List<OrderBasket> findAll() {
        return orderBasketRepository.findAll();
    }

    @Override
    public OrderBasket saveBasket(OrderBasket orderBasket) {
        return orderBasketRepository.save(orderBasket);
    }

    @Override
    public void deleteById(Long id) {
        orderBasketRepository.deleteById(id);
    }
}
