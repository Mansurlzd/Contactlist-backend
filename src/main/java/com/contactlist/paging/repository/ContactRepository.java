package com.contactlist.paging.repository;

import com.contactlist.paging.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ContactRepository extends JpaRepository<Contact, Long> {

    Page<Contact> findByName(String name, Pageable pageable);
    Page<Contact> findAll(Pageable pageable);
}
