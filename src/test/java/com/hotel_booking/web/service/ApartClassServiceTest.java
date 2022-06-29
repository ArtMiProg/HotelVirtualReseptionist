package com.hotel_booking.web.service;

import com.hotel_booking.web.model.entity.ApartClass;
import com.hotel_booking.web.model.repository.ApartClassRepository;
import com.hotel_booking.web.service.impl.ApartClassServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ApartClassServiceTest {

    @InjectMocks
    private ApartClassServiceImpl apartClassServiceImpl;

    @Mock
    private ApartClassRepository apartClassRepository;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        ApartClass expensive = new ApartClass();
        ApartClass cheap = new ApartClass();
        List<ApartClass> apartClassList = new ArrayList<>();
        apartClassList.add(expensive);
        apartClassList.add(cheap);
        when(apartClassRepository.findAll()).thenReturn(apartClassList);
        List<ApartClass> realApClasses = apartClassServiceImpl.getAll();
        verify(apartClassRepository).findAll();
        assertEquals(apartClassList, realApClasses);
    }

    @Test
    public void testGetById() {
        ApartClass friendly = new ApartClass();
        friendly.setId(8);
        when(apartClassRepository.getById(8)).thenReturn(friendly);
        ApartClass lucky = apartClassServiceImpl.getById(8);
        verify(apartClassRepository).getById(8);
        assertEquals(8, lucky.getId());
    }

    @Test
    public void testSave(){
        ApartClass toBeSaved = new ApartClass();
        apartClassServiceImpl.save(toBeSaved);
        verify(apartClassRepository, times(1)).save(any(ApartClass.class));
    }
}
