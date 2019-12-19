package com.mbste.service.impl;

import com.mbste.dao.NotificationDao;
import com.mbste.model.Notification;
import com.mbste.model.filters.NoficationFilter;
import com.mbste.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationDao dao;


    /**
     * TODO ngomba kuzana na description za appoitement
     * @param filter
     * @return
     */
    @Override
    public List<Notification> getNotifications(NoficationFilter filter) {
        return dao.getNotification(filter);
    }

    @Override
    public Integer createNotification(Notification notification) {
        return dao.createNotification(notification);
    }

    @Override
    public Integer deleteNotification(NoficationFilter filter) {
        return dao.deleteNotification(filter);
    }

    @Override
    public int createTable() {
        return dao.createTable();
    }

    @Override
    public int dropTable() {
        return dao.dropAllTables();
    }
}
