package bookShop.BookShop.controller;

import bookShop.BookShop.model.Status;
import bookShop.BookShop.service.Interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/ver1/statuses/")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Status> getStatus(@PathVariable("id") Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Status status = statusService.findById(id);

        if(status == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Status> saveStatus(@RequestBody @Validated Status status) {
        HttpHeaders headers = new HttpHeaders();

        if(status == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        statusService.saveStatuse(status);
        return new ResponseEntity<>(status, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Status> updateStatus(@RequestBody @Validated Status status, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if(status == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        statusService.saveStatuse(status);
        return new ResponseEntity<>(status, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Status> deletePerson(@PathVariable("id") Long id) {
        Status status = statusService.findById(id);

        if(status == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        statusService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<Status>> getAllStatuses() {
        List<Status> status = statusService.findAll();

        if(status.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
