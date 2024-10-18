package com.example.apid.controller;

import com.example.apid.service.PersonService;
import com.example.apid.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    // GET işlemi - Tüm kişileri getir
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    // POST işlemi - Yeni kişi ekle
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person savedPerson = personService.createPerson(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }
}