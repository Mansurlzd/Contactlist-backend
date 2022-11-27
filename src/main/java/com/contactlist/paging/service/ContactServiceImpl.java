package com.contactlist.paging.service;

import com.contactlist.paging.model.Contact;
import com.contactlist.paging.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public Page<Contact> getContacts(int index, int size) {

        return contactRepository.findAll(getPageable(index,size));
    }
    public Page<Contact> getContactsByName(String name, int index, int size) {
        return contactRepository.findByName(name,getPageable(index,size));
    }

    private Pageable getPageable(int index,int size){
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        return PageRequest.of(index, size, Sort.by(orders));
    }
}
