package com.hotel_booking.web.service;

import com.hotel_booking.web.model.entity.Role;
import com.hotel_booking.web.model.entity.User;
import com.hotel_booking.web.model.repository.UserRepository;
import com.hotel_booking.web.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoadUserByUsername() {
        User u = new User();
        u.setUsername("FionaMay");
        when(userRepository.findByUsername("FionaMay")).thenReturn(u);
        UserDetails user = userServiceImpl.loadUserByUsername("FionaMay");
        verify(userRepository).findByUsername("FionaMay");
        assertEquals("FionaMay", user.getUsername());
    }

    @Test
    public void testGetAll() {
        User sam = new User();
        User july = new User();
        List<User> usList = new ArrayList<>();
        usList.add(sam);
        usList.add(july);
        when(userRepository.findAll()).thenReturn(usList);
        List<User> realUsers = userServiceImpl.getAll();
        verify(userRepository).findAll();
        assertEquals(usList, realUsers);
    }

    @Test
    public void testGetById() {
        User u = new User();
        u.setId(1015);
        when(userRepository.getById(1015)).thenReturn(u);
        User user = userServiceImpl.getById(1015);
        verify(userRepository).getById(1015);
        assertEquals(1015, user.getId());
    }

    @Test
    public void testSaveUser() {
        User userForSaving = new User();
        userForSaving.setRoles(Collections.singleton(new Role(6, "ROLE_USER")));
        userForSaving.setPassword(bCryptPasswordEncoder.encode("55555"));
        userServiceImpl.saveUser(userForSaving);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testDeleteUser() {
        User userToBeDeleted = new User();
        userToBeDeleted.setId(1010);
        if (userRepository.findById(userToBeDeleted.getId()).isPresent()) {
            userServiceImpl.deleteUser(userToBeDeleted.getId());
        }
        verify(userRepository, times(1)).findById(1010);

    }
}
