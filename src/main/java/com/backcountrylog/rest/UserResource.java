package com.backcountrylog.rest;

import com.backcountrylog.model.User;
import com.backcountrylog.model.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.UnknownHostException;


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
        userDao = new UserDao();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() throws UnknownHostException {
        logger.info("Listing all users");
        //return userDao.findAll();
        return Response.ok(userDao.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public User getUserById(@PathParam("userId") String userId) {


        return userDao.findById(userId);

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(User user) throws UnknownHostException {
        userDao.save(user);
        logger.info("Successfully saved user: " + user.toString());
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

