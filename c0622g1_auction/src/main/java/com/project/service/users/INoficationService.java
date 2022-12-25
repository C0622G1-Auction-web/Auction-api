package com.project.service.users;

import com.project.model.users.Notification;

import java.util.List;
import java.util.Map;

public interface INoficationService {

    void save(Notification notification);

    List<Notification> getAllByUserId(Integer userId);

    List<Notification> getAllNoficationByAdmin();

    Notification finById(Integer id);
}
