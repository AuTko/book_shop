package bookShop.BookShop.repository;

import bookShop.BookShop.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByGroupAndDescription(Long group, String description);
}
