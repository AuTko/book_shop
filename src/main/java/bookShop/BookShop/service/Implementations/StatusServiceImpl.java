package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.model.Status;
import bookShop.BookShop.repository.StatusRepository;
import bookShop.BookShop.service.Interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    @Autowired
    StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status findById(Long id) {
        return statusRepository.findById(id).get();
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status saveStatus(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public void deleteById(Long id) {
        statusRepository.deleteById(id);
    }
}
