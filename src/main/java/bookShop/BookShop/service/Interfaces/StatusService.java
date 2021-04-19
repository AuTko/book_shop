package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Status;

import java.util.List;

public interface StatusService {

     Status findById(Long id);

     List<Status> findAll();

     Status saveStatuse(Status status);

     void deleteById(Long id);
}
