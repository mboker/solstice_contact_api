package com.boker.solstice.contacts.repo;

import com.boker.solstice.contacts.model.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by mboker on 4/25/18.
 */
public interface ContactRepo extends CrudRepository<Contact, Integer> {
    List<Contact> getContactsByState(String state);

    List<Contact> getContactsByCity(String city);

    Contact getContactByPhone(String phone);

    Contact getContactByEmail(String email);

    Contact updateContact(Contact contact);

    Boolean deleteContact(Integer id);

    Integer createContact(Contact contact);
}
