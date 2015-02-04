package com.outdoorlog.rest;

import com.outdoorlog.model.User;
import com.outdoorlog.model.UserDao;
import com.outdoorlog.mongo.MongoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.UnknownHostException;
import java.util.List;


/**
 * Created for Outdoorlog
 * UserResource: jonasbirgersson
 * Date: 2015-01-31
 * Time: 11:47 AM
 */
@Path("user")
public class UserResource {

    private final static Logger logger = LoggerFactory.getLogger(UserResource.class);


    private UserDao userDao;

    public UserResource() throws UnknownHostException {
        userDao = new UserDao(MongoUtil.getMorphia(), MongoUtil.getMongoClient());
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() throws UnknownHostException {
        logger.info("Listing all users");
        return userDao.findAll();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(User user) throws UnknownHostException {
        userDao.save(user);
        logger.info("Successfully saved user: " + user.toString());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public User getMsg(@PathParam("userId") String userId) {


        return  userDao.findById(userId);

    }

}

/*
curl -H "Content-Type: application/json" -d '{"firstName":"Kenneth","lastName":"Andersson"}' http://localhost:8080/webapi/user

/Product	GET	Hämtar en lista med alla produkter
/Product	POST	Skapar en ny produkt
/Product/{ProductID}	GET	Returnerar en produkt
/Product/{ProductID}	PUT	Uppdaterar en produkt
/Product/{ProductID}	DELETE	Tar bort en produkt
/ProductGroup/{ProductGroupID}	GET	Returnerar en produktgrupp


 */

