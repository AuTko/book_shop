package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.DTO.ShopDTO;
import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.Shop;

import java.util.List;

public interface ShopService {

    Shop findById(Long id);

    List<Shop> findAll();

    List<Shop> findByOwner(String email);

    Shop saveShop(ShopDTO shopDTO);

    void deleteById(Long id);


}
