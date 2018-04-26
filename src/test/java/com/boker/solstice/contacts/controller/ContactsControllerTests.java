package com.boker.solstice.contacts.controller;


import com.boker.solstice.contacts.model.Contact;
import com.boker.solstice.contacts.repo.ContactRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by mboker on 4/25/18.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ContactsController.class)
public class ContactsControllerTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    ContactRepo repo;

    @Test
    public void givenContact_whenGetContactWithId_thenReturnSingleContact() throws Exception{
        Contact contact = new Contact("address",
                "city",
                "state",
                "email",
                "phone",
                "name");
        contact.setId(1);

        given(repo.findById(1)).willReturn(Optional.of(contact));

        mvc.perform(get("/contact/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(contact.getId())))
                .andExpect(jsonPath("$.streetAddress", is(contact.getStreetAddress())))
                .andExpect(jsonPath("$.city", is(contact.getCity())))
                .andExpect(jsonPath("$.state", is(contact.getState())))
                .andExpect(jsonPath("$.emailAddress", is(contact.getEmailAddress())))
                .andExpect(jsonPath("$.phoneNumber", is(contact.getPhoneNumber())))
                .andExpect(jsonPath("$.fullName", is(contact.getFullName())));
    }

    @Test
    public void whenGetContactWithUnusedId_thenReturnEmptyBody() throws Exception{

        given(repo.findById(1)).willReturn(Optional.empty());

        mvc.perform(get("/contact/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").doesNotExist());
    }
}
