package com.mbste.controller;

import com.mbste.model.Notification;
import com.mbste.model.filters.NoficationFilter;
import com.mbste.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public List<Notification> getNotifications(@RequestBody NoficationFilter filter) {
        return service.getNotifications(filter);
    }

    @PostMapping(value = "/create", produces = "application/json;charset=UTF-8")
    public Integer createNotification(@RequestBody Notification notification) {

        return service.createNotification(notification);
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Integer deleteNotification(@RequestBody NoficationFilter filter) {
        return service.deleteNotification(filter);
    }
//    @RequestMapping("/createTable")
//    Integer createTable(){
//        return service.createTable();
//    }

}
