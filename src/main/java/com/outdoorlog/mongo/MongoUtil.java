package com.outdoorlog.mongo;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;

public class MongoUtil {

    private static Datastore ds;
    private static MongoClient mongoClient;
    private static Morphia morphia;

    public static Datastore getDatastore() {
        if (ds == null) {
            ds = new Morphia().createDatastore(mongoClient, "myDB");
        }
        return ds;
    }

    public static Morphia getMorphia() {
        if(morphia == null){
            morphia = new Morphia();
        }
        return morphia;
    }

    public static MongoClient getMongoClient() throws UnknownHostException {
        if(mongoClient == null){
            mongoClient = new MongoClient("localhost");
        }
        return mongoClient;
    }
}
