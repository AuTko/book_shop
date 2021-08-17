package bookShop.BookShop.service.Implementations;

import bookShop.BookShop.DTO.UserActivityDTO;
import bookShop.BookShop.model.UserActivity;
import bookShop.BookShop.repository.PersonRepository;
import bookShop.BookShop.repository.StatusRepository;
import bookShop.BookShop.repository.UserActivityRepository;
import bookShop.BookShop.service.Interfaces.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityServiceImpl implements UserActivityService {

    private final UserActivityRepository userActivityRepository;
    private final PersonRepository personRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public UserActivityServiceImpl(UserActivityRepository userActivityRepository, PersonRepository personRepository,
                                   StatusRepository statusRepository) {
        this.userActivityRepository = userActivityRepository;
        this.personRepository = personRepository;
        this.statusRepository = statusRepository;
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
    public List<UserActivity> getAllByUser(String email) {
        return userActivityRepository.findByUser(personRepository.findByEmail(email).getId());
    }

    @Override
    public List<UserActivity> getAllByAdmin(String email) {
        return userActivityRepository.findByAdmin(personRepository.findByEmail(email).getId());
    }

    @Override
    public UserActivity addActivity(UserActivityDTO userActivityDTO) {

        UserActivity userActivity = new UserActivity(userActivityDTO);
        userActivity.setUser(personRepository.findByEmail(userActivityDTO.getUser()));
        userActivity.setAdmin(personRepository.findByEmail(userActivityDTO.getAdmin()));
        // group 4 - user activity statuses
        userActivity.setActivity(statusRepository.findByGroupAndDescription(4L, userActivityDTO.getActivity()));

        return userActivityRepository.save(userActivity);
    }

    @Override
    public void deleteById(Long id) {
        userActivityRepository.deleteById(id);
    }
}
