package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Status;

import java.util.List;

public interface StatusService {

    Status findById(Long id);

    List<Status> findAll();

    Status saveStatus(Status status);

    void deleteById(Long id);
}
