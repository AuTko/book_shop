package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.model.Shop;
import bookShop.BookShop.repository.ShopRepository;
import bookShop.BookShop.service.Interfaces.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
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
    public Shop saveShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public void deleteById(Long id) {
        shopRepository.deleteById(id);
    }
}
