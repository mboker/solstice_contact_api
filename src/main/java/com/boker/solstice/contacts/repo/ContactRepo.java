package com.boker.solstice.contacts.repo;

import com.boker.solstice.contacts.model.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by mboker on 4/25/18.
 */
public interface ContactRepo extends CrudRepository<Contact, Integer> {
    List<Contact> findContactsByState(String state);

    List<Contact> findContactsByCity(String city);

    Contact findContactByPhoneNumber(String phone);

    Contact findContactByEmailAddress(String email);
}
