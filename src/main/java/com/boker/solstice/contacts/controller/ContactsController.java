package com.boker.solstice.contacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mboker on 4/24/18.
 */
@Controller
public class ContactsController {
    
    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "Hello World";
    }
}
