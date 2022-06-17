package com.hotel_booking.web.service;

import com.hotel_booking.web.model.entity.ApartClass;
import com.hotel_booking.web.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAll();
    User getById(Integer id);
    boolean saveUser (User user);
    boolean deleteUser (Integer id);
    List<User> userGetList(Integer idMin);
}
