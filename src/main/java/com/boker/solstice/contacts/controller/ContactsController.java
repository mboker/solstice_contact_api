package com.boker.solstice.contacts.controller;

import com.boker.solstice.contacts.model.Contact;
import com.boker.solstice.contacts.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by mboker on 4/24/18.
 */
@RequestMapping("/contact")
@RestController
public class ContactsController {
    @Autowired
    ContactRepo repo;

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    Contact getById(@PathVariable("id") Integer id){
        Optional<Contact> contactRetrieval = repo.findById(id);
        if (contactRetrieval.isPresent()){
            return contactRetrieval.get();
        }
        return null;
    }

    @RequestMapping(value="/email/{email}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    Contact geyByEmail(@PathVariable("email") String email){
        Contact contact = repo.findContactByEmailAddress(email);
        return contact;
    }

    @RequestMapping(value="/phone/{phone}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    Contact getByPhone(@PathVariable("phone") String phone){
        Contact contact = repo.findContactByPhoneNumber(phone);
        return contact;
    }

    @RequestMapping(value="/", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    Integer createContact(@RequestBody Contact contact){
        return repo.save(contact).getId();
    }

    @RequestMapping(value="/", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    Contact updateContact(@RequestBody Contact contact){
        return repo.save(contact);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    void deleteContact(@PathVariable("id") int id){
        repo.deleteById(id);
    }

    @RequestMapping(value="/state/{state}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    List<Contact> searchByState(@PathVariable("state") String state){
        List<Contact> results = repo.findContactsByState(state);
        return results;
    }

    @RequestMapping(value="/city/{city}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    List<Contact> searchByCity(@PathVariable("city") String city){
        List<Contact> results = repo.findContactsByCity(city);
        return results;
    }
}
