package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.DTO.OrderBasketDTO;
import bookShop.BookShop.model.OrderBasket;
import bookShop.BookShop.repository.OrderBasketRepository;
import bookShop.BookShop.repository.PersonRepository;
import bookShop.BookShop.repository.StatusRepository;
import bookShop.BookShop.service.Interfaces.OrderBasketService;
import bookShop.BookShop.service.Interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBasketServiceImpl implements OrderBasketService {

    private final OrderBasketRepository orderBasketRepository;
    private final PersonRepository personRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public OrderBasketServiceImpl(OrderBasketRepository orderBasketRepository, PersonRepository personRepository, StatusRepository statusRepository) {
        this.orderBasketRepository = orderBasketRepository;
        this.personRepository = personRepository;
        this.statusRepository = statusRepository;
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
    public OrderBasket saveBasket(OrderBasketDTO orderBasketDTO) {
        OrderBasket orderBasket = new OrderBasket(orderBasketDTO);
        orderBasket.setPerson(personRepository.findByEmail(orderBasketDTO.getPerson()));
        // group 3 - orderBasket statuses
        orderBasket.setStatus(statusRepository.findByGroupAndDescription(3L, orderBasket.getDescription()));

        return orderBasketRepository.save(orderBasket);
    }

    @Override
    public void deleteById(Long id) {
        orderBasketRepository.deleteById(id);
    }
}
