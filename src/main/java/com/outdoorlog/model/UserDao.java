package com.outdoorlog.model;

import com.outdoorlog.mongo.MongoUtil;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created for Outdoorlog
 * UserResource: jonasbirgersson
 * Date: 2015-01-30
 * Time: 6:56 PM
 */
public class UserDao extends BasicDAO<User, ObjectId> {

    public UserDao() throws UnknownHostException {
        super(MongoUtil.getMongoClient(), MongoUtil.getMorphia(), "outdoorlog");
    }

    public List<User> findAll() {
        return getDatastore().find(User.class).asList();
    }


    public User findById(String id){
        ObjectId oid = new ObjectId(id);

        return getDatastore().get(User.class, oid);
    }


    public void addUser(User user) {
        Key<User> key = getDatastore().save(user);
    }
}
/*
*
* Product	GET	Hämtar en lista med alla produkter
/Product	POST	Skapar en ny produkt
/Product/{ProductID}	GET	Returnerar en produkt
/Product/{ProductID}	PUT	Uppdaterar en produkt
/Product/{ProductID}	DELETE	Tar bort en produkt
/ProductGroup/{ProductGroupID}	GET	Returnerar en produktgrupp
* */