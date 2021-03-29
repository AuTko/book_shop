package bookShop.BookShop.service.Interfaces;

import bookShop.BookShop.model.Status;

import java.util.List;

public interface StatusService {

    public Status findById(Long id);

    public List<Status> findAll();

    public Status saveStatuse(Status status);

    public void deleteById(Long id);
}
