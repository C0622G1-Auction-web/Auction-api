package com.project.controller.users;

import com.project.model.users.Notification;
import com.project.service.users.INoficationService;
import com.project.service.users.impl.NoficationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/nofications")
public class NoficationRestController {
    @Autowired
    private INoficationService iNoficationService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Notification>> getAllNoficationByUserId(@PathVariable Integer userId) {
        List<Notification> notifications = iNoficationService.getAllByUserId(userId);
        if(notifications == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<Notification>> getAllNoficationByAdmin() {
        List<Notification> notifications = iNoficationService.getAllNoficationByAdmin();
        if(notifications == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping("/noficationed/{id}")
    public ResponseEntity<Notification> setNoficationed(@PathVariable Integer id) {
        Notification notification = iNoficationService.finById(id);
        notification.setStatus(2);
        iNoficationService.save(notification);
        return new ResponseEntity<>(notification, HttpStatus.OK);
    }
}
