package com.contactlist.paging.util;

import com.contactlist.paging.model.Contact;
import com.contactlist.paging.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitializeData {

    private final ContactRepository contactRepository;

    @PostConstruct
    private void initializeData() {
        try {
            File file = ResourceUtils.getFile("classpath:csv/people.csv");
            List<Contact> contacts = Files.readAllLines(file.toPath())
                    .stream()
                    .map(m -> m.split(","))
                    .map(c -> new Contact(c[0], c[1]))
                    .collect(Collectors.toList());

            contactRepository.saveAll(contacts);
        } catch (Exception e) {
            log.error("Error occurred while parsing data");
        }
    }


}
