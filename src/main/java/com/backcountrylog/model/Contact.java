package com.backcountrylog.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.backcountrylog.mongo.util.ObjectIDSerializer;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

public class Contact {

    @JsonSerialize(using = ObjectIDSerializer.class)
    @Id
    private ObjectId id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    @Embedded
    private Address address;

}
