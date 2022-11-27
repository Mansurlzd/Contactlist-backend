package com.contactlist.paging.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="contact")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name ="imageUrl")
    private String imageUrl;

    public Contact(String name,String imageUrl){
        this.name = name;
        this.imageUrl = imageUrl;
    }

}
