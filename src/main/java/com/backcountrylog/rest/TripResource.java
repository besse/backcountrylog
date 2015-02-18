package com.backcountrylog.rest;

import com.backcountrylog.model.Trip;
import com.backcountrylog.model.TripDao;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created for Outdoorlog
 * User: jonasbirgersson
 * Date: 2015-02-07
 * Time: 3:32 PM
 */
@Path("trip")
public class TripResource {

    private final static Logger logger = LoggerFactory.getLogger(TripResource.class);


    private TripDao tripDao;

    public TripResource() throws UnknownHostException {
        tripDao = new TripDao();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trip> getTrips() {
        logger.info("Getting all trips from db");
        return tripDao.findAll();
    }

    @GET
    @Path("/{tripId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Trip getTripById(@PathParam("tripId") String id) {
        ObjectId oid = new ObjectId(id);
        logger.info("Finding trip with id: {}", id);
        return tripDao.findById(oid);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Trip saveTrip(Trip trip) {
        logger.info("Saving trip...");
        return tripDao.addTrip(trip);
    }


}
