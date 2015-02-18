package com.backcountrylog.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.backcountrylog.mongo.util.ObjectIDSerializer;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value = "destination", noClassnameStored = true)
public class Destination {

    @JsonSerialize(using = ObjectIDSerializer.class)
    @Id
    private ObjectId id;

    private String name;
    private String description;
    private double latitude;
    private double longitude;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
