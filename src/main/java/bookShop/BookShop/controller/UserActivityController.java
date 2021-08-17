package bookShop.BookShop.controller;

import bookShop.BookShop.DTO.StockDTO;
import bookShop.BookShop.DTO.UserActivityDTO;
import bookShop.BookShop.model.Person;
import bookShop.BookShop.service.Interfaces.PersonService;
import bookShop.BookShop.service.Interfaces.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/ver1/activity/")
public class UserActivityController {

    private final UserActivityService userActivityService;

    @Autowired
    public UserActivityController(UserActivityService userActivityService) {
        this.userActivityService = userActivityService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserActivityDTO> getUserActivity(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserActivityDTO userActivityDTO = new UserActivityDTO(userActivityService.findById(id));

        if (userActivityDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userActivityDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserActivityDTO> saveUserActivity(@RequestBody @Validated UserActivityDTO userActivityDTO) {
        HttpHeaders headers = new HttpHeaders();

        if (userActivityDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userActivityService.addActivity(userActivityDTO);

        return new ResponseEntity<>(userActivityDTO, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserActivityDTO> updateStock(@RequestBody @Validated UserActivityDTO userActivityDTO,
                                                       UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (userActivityDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userActivityService.addActivity(userActivityDTO);

        return new ResponseEntity<>(userActivityDTO, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<UserActivityDTO> deleteStock(@PathVariable("id") Long id) {

        UserActivityDTO userActivityDTO = new UserActivityDTO(userActivityService.findById(id));

        if (userActivityDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userActivityService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<UserActivityDTO[]> getAllActivities() {

        UserActivityDTO[] userActivityDTOS = userActivityService.findAll().stream().map(UserActivityDTO::new).
                toArray(UserActivityDTO[]::new);

        if (userActivityDTOS.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userActivityDTOS, HttpStatus.OK);
    }


    @GetMapping(value = "admin/{email}")
    public ResponseEntity<UserActivityDTO[]> getAdminActivities(@PathVariable("email") String email) {

        if (email == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserActivityDTO[] userActivityDTOS = userActivityService.getAllByAdmin(email).stream().
                map(UserActivityDTO::new).toArray(UserActivityDTO[]::new);

        if (userActivityDTOS.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userActivityDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "user/{email}")
    public ResponseEntity<UserActivityDTO[]> getUserActivities(@PathVariable("email") String email) {

        if (email == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserActivityDTO[] userActivityDTOS = userActivityService.getAllByUser(email).stream().
                map(UserActivityDTO::new).toArray(UserActivityDTO[]::new);

        if (userActivityDTOS.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userActivityDTOS, HttpStatus.OK);
    }
}
