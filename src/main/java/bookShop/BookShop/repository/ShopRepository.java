package bookShop.BookShop.repository;

import bookShop.BookShop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    Shop findByShopName(String shopName);

    List<Shop> findByOwner(Long id);
}
