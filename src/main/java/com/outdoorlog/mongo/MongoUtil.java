package com.outdoorlog.mongo;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Properties;

public class MongoUtil {

    private static Logger logger = LoggerFactory.getLogger(MongoUtil.class);

    private static Datastore ds;
    private static MongoClient mongoClient;
    private static Morphia morphia;
    private static Properties properties;

    public static Datastore getDatastore() {
        if (ds == null) {
            ds = new Morphia().createDatastore(mongoClient, getProperty("dbName"));
        }
        return ds;
    }

    public static Morphia getMorphia() {
        if (morphia == null) {
            morphia = new Morphia();
        }
        return morphia;
    }

    public static MongoClient getMongoClient() throws UnknownHostException {
        if (mongoClient == null) {
            mongoClient = new MongoClient(getProperty("hostName"));
        }
        return mongoClient;
    }

    public static String getProperty(String propertyName) {
        if (properties == null) {
            try {
                properties = new Properties();
                InputStream inputStream = MongoUtil.class.getResourceAsStream("/database.properties");

                properties.load(inputStream);

            } catch (IOException e) {
                logger.error("Couldn't load database properties" + e.getMessage());
            }
        }
        return properties.getProperty(propertyName);
    }


}
