package com.mbste.dao;

import com.mbste.model.Notification;
import com.mbste.model.filters.NoficationFilter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationDao
{
    List<Notification> getNotification(NoficationFilter filter);

    Integer createNotification(Notification notification);

    Integer deleteNotification(NoficationFilter filter);

    int createTable();
}
