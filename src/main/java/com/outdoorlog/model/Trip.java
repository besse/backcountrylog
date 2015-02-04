package com.outdoorlog.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;
import java.util.List;

public class Trip {

    @Id
    private ObjectId id;
    private User leader;
    @Reference("partyMembers")
    private List<User> partyMembers;

    @Reference
    private Destination destination;

    private Date startTime;
    private Date expectedEndTime;

    public ObjectId getId() {
        return id;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public List<User> getPartyMembers() {
        return partyMembers;
    }

    public void setPartyMembers(List<User> partyMembers) {
        this.partyMembers = partyMembers;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getExpectedEndTime() {
        return expectedEndTime;
    }

    public void setExpectedEndTime(Date expectedEndTime) {
        this.expectedEndTime = expectedEndTime;
    }
}
