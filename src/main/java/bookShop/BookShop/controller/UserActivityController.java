package bookShop.BookShop.controller;

import bookShop.BookShop.model.Person;
import bookShop.BookShop.model.UserActivity;
import bookShop.BookShop.service.Interfaces.PersonService;
import bookShop.BookShop.service.Interfaces.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/ver1/activity/")
public class UserActivityController {

    private final UserActivityService userActivityService;

    @Autowired
    public UserActivityController(UserActivityService userActivityService) {
        this.userActivityService = userActivityService;
    }

    @GetMapping
    public ResponseEntity<List<UserActivity>> getAllActivity() {

        List<UserActivity> allActivity = userActivityService.findAll();

        if(allActivity.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(allActivity, HttpStatus.OK);
    }


    @GetMapping(value = "admin/{id}")
    public ResponseEntity<List<UserActivity>> getAdminActivity(@PathVariable("id") Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<UserActivity> adminActivity = userActivityService.getAllByAdminId(id);

        if(adminActivity.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(adminActivity, HttpStatus.OK);
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<List<UserActivity>> getUserActivity(@PathVariable("id") Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<UserActivity> userActivity = userActivityService.getAllByUserId(id);

        if(userActivity.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userActivity, HttpStatus.OK);
    }
}
