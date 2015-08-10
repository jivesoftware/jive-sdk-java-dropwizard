package com.jivesoftware.ps.hello.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by chris.dempsey on 8/10/15.
 */
@Path("/hello/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorld {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    @GET
    public Response sayHello(@QueryParam("name") Optional<String> name) {
        return Response.ok("{ \"response\": \"Hello World!\" }").build();
    }
}
