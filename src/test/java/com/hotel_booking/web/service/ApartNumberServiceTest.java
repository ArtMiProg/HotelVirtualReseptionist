package com.hotel_booking.web.service;

import com.hotel_booking.web.model.entity.ApartClass;
import com.hotel_booking.web.model.entity.ApartNumber;
import com.hotel_booking.web.model.entity.User;
import com.hotel_booking.web.model.repository.ApartClassRepository;
import com.hotel_booking.web.service.impl.ApartClassServiceImpl;
import com.hotel_booking.web.service.impl.ApartNumberServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApartNumberServiceTest {

    @InjectMocks
    private ApartNumberServiceImpl apartNumberServiceImpl;

    @Mock
    private ApartClassRepository apartClassRepository;

    @Mock
    private ApartClassServiceImpl apartClassServiceImpl;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetApclassById(){
        ApartClass apartClass = new ApartClass();
        apartClass.setId(1);
        apartClass.setApclass("Econom");
        when(apartClassRepository.getById(1)).thenReturn(apartClass);
        String anotherClass =  apartNumberServiceImpl.getApclassById(1);
        verify(apartClassRepository).getById(1);
        assertEquals(anotherClass, apartClass.getApclass());
    }
}
