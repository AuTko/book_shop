package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.DTO.ShopDTO;
import bookShop.BookShop.model.Shop;
import bookShop.BookShop.repository.PersonRepository;
import bookShop.BookShop.repository.ShopRepository;
import bookShop.BookShop.repository.StatusRepository;
import bookShop.BookShop.service.Interfaces.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final PersonRepository personRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, PersonRepository personRepository,
                           StatusRepository statusRepository) {
        this.shopRepository = shopRepository;
        this.personRepository = personRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public Shop findById(Long id) {
        return shopRepository.findById(id).get();
    }

    @Override
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Override
    public List<Shop> findByOwner(String email) {
        return shopRepository.findByOwner(personRepository.findByEmail(email).getId());
    }

    @Override
    public Shop saveShop(ShopDTO shopDTO) {

        Shop shop = new Shop(shopDTO);
        shop.setOwner(personRepository.findByEmail(shopDTO.getOwner()));
        // group 1 - shop statuses
        shop.setStatus(statusRepository.findByGroupAndDescription(1L, shopDTO.getStatus()));
        return shopRepository.save(shop);
    }

    @Override
    public void deleteById(Long id) {
        shopRepository.deleteById(id);
    }
}
