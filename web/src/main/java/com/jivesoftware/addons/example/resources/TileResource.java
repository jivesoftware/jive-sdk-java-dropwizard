package com.jivesoftware.addons.example.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tile")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TileResource {

    @POST
    @Path("/register")
    @Timed
    public Response register(String registrationJson) {
        return Response.ok().entity("{ \"status\": \"tile registered\" }").build();
    }

    @POST
    @Path("/unregister")
    @Timed
    public Response unregister(String unregistrationJson) {
        return Response.ok().entity("{ \"status\": \"tile unregistered\" }").build();
    }
}
