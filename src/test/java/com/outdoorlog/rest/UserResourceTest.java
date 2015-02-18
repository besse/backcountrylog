package com.outdoorlog.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import javax.ws.rs.core.Application;

/**
 * Created for Outdoorlog
 * User: jonasbirgersson
 * Date: 2015-02-07
 * Time: 1:14 PM
 */
public class UserResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(UserResource.class);
    }
}
