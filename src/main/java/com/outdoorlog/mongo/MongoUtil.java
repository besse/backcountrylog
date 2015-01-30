package com.outdoorlog.mongo;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MongoUtil {

    private static Datastore ds;
    private static MongoClient mongoClient;

    public static Datastore getDatastore() {
        if (ds == null) {
            ds = new Morphia().createDatastore(mongoClient, "myDB");
        }
        return ds;
    }
}
