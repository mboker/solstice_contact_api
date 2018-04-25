package com.boker.solstice.contacts.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mboker on 4/24/18.
 */
@Entity
@Table(name="contact")
public class Contact implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="street_address")
    private String streetAddress;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="full_name")
    private String fullName;

    protected Contact(){}

    public Contact(String streetAddress,
                   String city,
                   String state,
                   String emailAddress,
                   String phoneNumber,
                   String fullName){
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
