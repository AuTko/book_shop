package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.Shop;

import java.util.List;

public interface ShopService {

     Shop findById(Long id);

     List<Shop> findAll();

     Shop saveShop(Shop shop);

     void deleteById(Long id);
}
