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
 * Time: 4:51 PM
 */
public class DestinationDao extends BasicDAO<Trip, ObjectId> {

    public DestinationDao() throws UnknownHostException {
        super(MongoUtil.getMongoClient(), MongoUtil.getMorphia(), MongoUtil.getProperty("dbName"));
    }

    public List<Destination> findAll() {
        return getDatastore().find(Destination.class).asList();
    }

    public Destination addDestination(Destination destination) {
        Key<Destination> key = getDatastore().save(destination);
        return destination;
    }


}
