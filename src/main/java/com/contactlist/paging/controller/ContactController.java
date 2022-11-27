package com.contactlist.paging.controller;

import com.contactlist.paging.exception.NoDataFoundException;
import com.contactlist.paging.model.Contact;
import com.contactlist.paging.service.ContactService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:8081")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllContacts(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        try {

            List<Contact> contacts;
            Page<Contact> contactPage;
            if (name == null){
                contactPage = contactService.getContacts(page,size);
            }
            else { contactPage = contactService.getContactsByName(name, page,size); }

            contacts = contactPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("contacts", contacts);
            response.put("currentPage", contactPage.getNumber());
            response.put("totalItems", contactPage.getTotalElements());
            response.put("totalPages", contactPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e) {
            throw new NoDataFoundException();

        }
    }

}
