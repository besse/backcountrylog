package com.backcountrylog.model;

import com.backcountrylog.mongo.MongoUtil;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created for Outdoorlog
 * User: jonasbirgersson
 * Date: 2015-02-07
 * Time: 3:36 PM
 */
public class TripDao extends BasicDAO<Trip, ObjectId> {

    public TripDao() throws UnknownHostException {
        super(MongoUtil.getMongoClient(), MongoUtil.getMorphia(), "backcountrylog");
    }

    public List<Trip> findAll() {
        return getDatastore().find(Trip.class).asList();
    }

    public Trip findById(ObjectId oid) {
        Trip trip = getDatastore().get(Trip.class, oid);
        return trip;
    }

    public Trip addTrip(Trip trip) {
        Key<Trip> key = getDatastore().save(trip);
        return trip;
    }
}
