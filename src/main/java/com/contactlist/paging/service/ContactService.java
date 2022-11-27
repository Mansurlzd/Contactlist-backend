package com.contactlist.paging.service;


import com.contactlist.paging.model.Contact;
import org.springframework.data.domain.Page;



public interface ContactService {

    Page<Contact> getContacts(int index, int size);
    Page<Contact> getContactsByName(String name, int index, int size);


}
