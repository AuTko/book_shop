package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.Shop;

import java.util.List;

public interface ShopService {

    public Shop findById(Long id);

    public List<Shop> findAll();

    public Shop saveShop(Shop shop);

    public void deleteById(Long id);
}
