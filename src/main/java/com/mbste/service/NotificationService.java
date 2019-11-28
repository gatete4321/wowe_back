package com.mbste.service;

import com.mbste.model.Notification;
import com.mbste.model.filters.NoficationFilter;


import java.util.List;

public interface NotificationService
{
    public List<Notification> getNotifications(NoficationFilter filter);

    public Integer createNotification(Notification notification);

    public Integer deleteNotification(NoficationFilter filter);


}
