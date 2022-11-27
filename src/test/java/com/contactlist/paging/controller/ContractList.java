package com.contactlist.paging.controller;

import com.contactlist.paging.model.Contact;
import com.contactlist.paging.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;



@SpringBootTest
class ContractList {

    @Autowired
    ContactService contactService;


    @Test
    public void test_getContactListSize(){
        Page<Contact> list = contactService.getContacts(0, 50);
        assert list.getSize() == 50;
    }

}