package com.jivesoftware.sdk.services.jersey.filters;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.message.internal.ReaderWriter;
import org.glassfish.jersey.server.ContainerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jivesoftware.sdk.util.JiveSDKUtils;

/**
 * Created by rrutan on 1/30/14.
 */
public abstract class BaseContainerRequestFilter implements ContainerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(BaseContainerRequestFilter.class);

    protected final static WebApplicationException VALIDATION_FAILED =
       new WebApplicationException(
           Response.status(Response.Status.BAD_REQUEST).build());

    protected final static WebApplicationException UNAUTHORIZED =
       new WebApplicationException(
           Response.status(Response.Status.UNAUTHORIZED).build());

    protected String getJsonBody(ContainerRequestContext containerRequestContext) {
        String body = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream in = containerRequestContext.getEntityStream();

        final StringBuilder b = new StringBuilder();
        try {
            //REMOVED THE in.available() CHECK AS THIS DOESNT WORK IN TOMCAT WITH JERSEY
            //SEE: https://java.net/jira/browse/JERSEY-749
            if (log.isTraceEnabled()) { log.trace("Data Available..."); }
            ReaderWriter.writeTo(in, out);
            containerRequestContext.setEntityStream(new ByteArrayInputStream(out.toByteArray()));
            body = new String(out.toByteArray());
            if (log.isTraceEnabled()) { log.trace("Data Read:\n["+body+"]"); }
        } catch (IOException ex) {
            log.error("Error while reading JSON body",ex);
            throw new ContainerException(ex);
        } // end try/catch

        if (log.isDebugEnabled()) {
            if (MediaType.APPLICATION_JSON.equals(containerRequestContext.getHeaderString(HttpHeaders.CONTENT_TYPE))) {
                log.debug("\n["+containerRequestContext.getMethod()+"] : "+containerRequestContext.getUriInfo().getPath()+"\n"+ JiveSDKUtils.getJson(body));
            } else {
                log.debug("\n["+containerRequestContext.getMethod()+"] : "+containerRequestContext.getUriInfo().getPath()+"\n"+body);
            } // end if
        } // end if

        return body;
    } // end getJsonBody

} // end class