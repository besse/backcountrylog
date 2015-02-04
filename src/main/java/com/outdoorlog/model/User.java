package com.outdoorlog.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.outdoorlog.mongo.util.ObjectIDSerializer;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value = "users", noClassnameStored = true)
public class User {

    @JsonSerialize(using = ObjectIDSerializer.class)
    @Id
    private ObjectId id;


    private String firstName;
    private String lastName;


    @Embedded
    private Address address;


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public ObjectId getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "UserResource{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}

