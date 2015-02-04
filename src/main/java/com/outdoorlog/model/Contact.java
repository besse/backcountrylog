package com.outdoorlog.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

public class Contact {

    @Id
    private ObjectId id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    @Embedded
    private Address address;

}
