package com.jivesoftware.addons.example.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.jivesoftware.sdk.definition.api.tile.TileRegister;
import com.jivesoftware.sdk.definition.api.tile.TileUnregister;
import com.jivesoftware.sdk.services.jersey.filters.JiveAuthorizationValidation;

@Path("/tile")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TileService {

    @POST
    @Path("/register")
    @JiveAuthorizationValidation
    @Timed
    public Response register(TileRegister data) {
        return Response.ok().entity("{ \"status\": \"tile registered\" }").build();
    }

    @POST
    @Path("/unregister")
    @Timed
    @JiveAuthorizationValidation
    public Response unregister(TileUnregister data) {
        return Response.ok().entity("{ \"status\": \"tile unregistered\" }").build();
    }
}
