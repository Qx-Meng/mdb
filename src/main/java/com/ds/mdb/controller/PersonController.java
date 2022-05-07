package com.ds.mdb.controller;

import com.ds.mdb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;


    @RequestMapping("/insert")
    public String insert(){
        personService.insert();
        return "insert ok";
    }

    @RequestMapping("/query")
    public String query(){
        return personService.query();
    }
}
