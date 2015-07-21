package com.jivesoftware.sdk.services.jersey.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jivesoftware.sdk.util.JiveAuthorizationValidator;

/**
 * Created by rrutan on 1/30/14.
 */
@Provider
@JiveAuthorizationValidation
public class JiveAuthorizationValidationRequestFilter extends BaseContainerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(JiveAuthorizationValidationRequestFilter.class);

    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if (log.isTraceEnabled()) { log.trace("filter called"); }
        if (log.isDebugEnabled()) {
            getJsonBody(containerRequestContext);
        } // end if

        JiveAuthorizationValidator.authenticate(containerRequestContext);
    } // end filter

} // end class