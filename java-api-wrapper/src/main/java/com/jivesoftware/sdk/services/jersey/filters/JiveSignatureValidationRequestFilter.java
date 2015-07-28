package com.jivesoftware.sdk.services.jersey.filters;
import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jivesoftware.sdk.definition.api.addon.AddOnRegister;
import com.jivesoftware.sdk.util.JiveSignatureValidator;

/**
 * Created by rrutan on 1/30/14.
 */
@Provider
@JiveSignatureValidation
public class JiveSignatureValidationRequestFilter extends BaseContainerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(JiveSignatureValidationRequestFilter.class);

    private ObjectMapper objectMapper = null;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if (log.isTraceEnabled()) { log.trace("filter called"); }
        String jsonBody = getJsonBody(containerRequestContext);

        if (jsonBody == null || jsonBody.trim().length() < 1) {
            if (log.isDebugEnabled()) { log.debug("Invalid JSON Body, Unable to Validate Signtature"); }
            throw UNAUTHORIZED;
        } // end if

        //TODO: NEED TO GO THROUGH AND SEE IF THIS FILTER WILL BE USED ON ANY OTHER ACTION, IF SO .. ABSTRACT ACCORDINGLY

        AddOnRegister registerData = new ObjectMapper().readValue(jsonBody, AddOnRegister.class);

        if (registerData == null ||
    		registerData.getJiveSignature() == null ||
			registerData.getJiveSignatureURL() == null) {
            throw UNAUTHORIZED;
        } // end if


        if (!JiveSignatureValidator.isValidSignature(registerData)) {
            log.error("Invalid Signature Validation");
            throw VALIDATION_FAILED;
        } // end if

    } // end filter

} // end filter