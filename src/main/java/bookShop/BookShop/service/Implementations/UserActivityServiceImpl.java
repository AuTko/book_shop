package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.UserActivity;
import bookShop.BookShop.repository.PersonRepository;
import bookShop.BookShop.repository.UserActivityRepository;
import bookShop.BookShop.service.Interfaces.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityServiceImpl implements UserActivityService {

    private final UserActivityRepository userActivityRepository;

    @Autowired
    public UserActivityServiceImpl(UserActivityRepository userActivityRepository) {
        this.userActivityRepository = userActivityRepository;
    }

    //Basically getOne is a lazy load operation. Thus you get only a reference (a proxy) to the entity.
    // That means no DB access is actually made.
    @Override
    public UserActivity findById(Long id) {
        return userActivityRepository.findById(id).get();
    }

    @Override
    public List<UserActivity> findAll() {
        return userActivityRepository.findAll();
    }

    @Override
    public List<UserActivity> getAllByUserId(Long id) {
        return userActivityRepository.getAllByUser_Id(id);
    }

    @Override
    public List<UserActivity> getAllByAdminId(Long id) {
        return userActivityRepository.getAllByAdmin_Id(id);
    }

    @Override
    public UserActivity addActivity(UserActivity userActivity) {
        return userActivityRepository.save(userActivity);
    }

    @Override
    public void deleteById(Long id) {
        userActivityRepository.deleteById(id);
    }
}
