package com.outdoorlog.model;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.List;

@Entity
public class User {

    @Id
    private ObjectId id;

    private String firstName;
    private String lastName;


}
