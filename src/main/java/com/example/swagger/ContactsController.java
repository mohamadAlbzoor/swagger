package com.example.swagger;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactsController {

    List<Contact> contList = Arrays.asList(
            new Contact("123", "mo", "email1@gamil.com"),
            new Contact("1234", "ahmad", "email2@gamil.com"),
            new Contact("12345", "taheeeerr", "email3@gamil.com")
    );

    @GetMapping("/")
    public List<Contact> getAllContacts(){
        return this.contList;
    }

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable String id){
        return (Contact) this.contList.stream().filter(c -> c.getId().equals(id));
    }

    @PostMapping("/")
    public void addContact(@RequestBody Contact contact){
        contList.add(contact);
    }
}
