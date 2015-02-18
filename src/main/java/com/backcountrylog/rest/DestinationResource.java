package com.backcountrylog.rest;

import com.backcountrylog.model.Destination;
import com.backcountrylog.model.DestinationDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created for Outdoorlog
 * User: jonasbirgersson
 * Date: 2015-02-07
 * Time: 4:59 PM
 */
@Path("destination")
public class DestinationResource {

    private DestinationDao destinationDao;

    public DestinationResource() throws UnknownHostException {
        destinationDao = new DestinationDao();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Destination> getDestinations() {
        return destinationDao.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Destination addDestination(Destination destination) {
        return destinationDao.addDestination(destination);
    }

}
