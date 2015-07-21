package com.jivesoftware.addons.example.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.jivesoftware.sdk.definition.api.addon.AddOnRegister;
import com.jivesoftware.sdk.definition.api.addon.AddOnUnregister;
import com.jivesoftware.sdk.services.jersey.filters.JiveSignatureValidation;

@Path("/instance")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InstanceService {

    @POST
    @Path("/register")
    @JiveSignatureValidation // NOTE: CONFIRM THAT THIS SHOULDN'T BE - @JiveAuthorizationValidation
    @Timed
    public Response register(AddOnRegister data) {
        return Response.ok().entity("{ \"status\": \"instance registered\" }").build();
    } // end register

    @POST
    @Path("/unregister")
    @JiveSignatureValidation // NOTE: CONFIRM THAT THIS SHOULDN'T BE - @JiveAuthorizationValidation
    @Timed
    public Response unregister(AddOnUnregister data) {
        return Response.ok().entity("{ \"status\": \"instance unregistered\" }").build();
    } // end register

} // end class
