package com.hotel_booking.web.controller;

import com.hotel_booking.web.model.entity.User;
import com.hotel_booking.web.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {

    @InjectMocks
    private AdminController adminController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @Before
    public void init() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/main/webapp/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).setViewResolvers(viewResolver).build();
    }

    @Test
    public void testUserList() throws Exception {

        User sam = new User();
        sam.setId(1);
        sam.setName("Sam");
        sam.setSurname("Morning");
        sam.setRoleId(6);
        sam.setUsername("SamMorning");
        sam.setPassword("55555");
        sam.setPasswordConfirm("55555");
        User july = new User();
        july.setId(2);
        july.setName("July");
        july.setSurname("Quin");
        july.setRoleId(6);
        july.setUsername("JulyQuin");
        july.setPassword("55555");
        july.setPasswordConfirm("55555");
        when(userService.getAll()).thenReturn(Arrays.asList(sam, july));
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin"))
                .andExpect(forwardedUrl("/main/webapp/WEB-INF/views/admin.jsp"))
                .andExpect(model().attribute("allUsers", hasSize(2)))
                .andExpect(model().attribute("allUsers", hasItem(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("name", is("Sam")),
                                hasProperty("surname", is("Morning")),
                                hasProperty("roleId", is(6)),
                                hasProperty("username", is("SamMorning")),
                                hasProperty("password", is("55555")),
                                hasProperty("passwordConfirm", is("55555"))
                        )
                )))
                .andExpect(model().attribute("allUsers", hasItem(
                        allOf(
                                hasProperty("id", is(2)),
                                hasProperty("name", is("July")),
                                hasProperty("surname", is("Quin")),
                                hasProperty("roleId", is(6)),
                                hasProperty("username", is("JulyQuin")),
                                hasProperty("password", is("55555")),
                                hasProperty("passwordConfirm", is("55555"))
                        )
                )));
        verify(userService, times(1)).getAll();
        verifyNoMoreInteractions(userService);
    }
}
