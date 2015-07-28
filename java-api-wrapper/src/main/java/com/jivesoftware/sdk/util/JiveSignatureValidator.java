package com.jivesoftware.sdk.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jivesoftware.sdk.services.jersey.filters.JiveSignatureValidatable;

import javax.inject.Singleton;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by rrutan on 1/30/14.
 */
@Singleton
public class JiveSignatureValidator {
    private static final Logger log = LoggerFactory.getLogger(JiveSignatureValidator.class);

    public static boolean isValidSignature(JiveSignatureValidatable request) {
    	//TODO: SHOULD BAKE IN A MEANS TO BYPASS VALIDATION FOR DEVELOPMENT PURPOSES
//    	if (config.isDevelopment() && config.isIgnoreSignatureValidation()) {
//            log.debug("ignoreSignatureValidation enabled in jiveclientconfiguraiton.properties ... returning [true]");
//            return true;
//        } // end if
        String signature = request.getJiveSignature();
        String signatureURL = request.getJiveSignatureURL();
        boolean isHttps = signatureURL.toLowerCase().startsWith("https");

        if (signature == null || signatureURL == null) {
            String msg = String.format("Invalid signature [%s] or signature URL [%s]", signature, signatureURL);
            log.error(msg);
            return false;
        } // end if

//		  TODO: NEED TO ENFORCE HTTPS FOR NON-DEVELOPMENT ENVIRONMENTS
//        if (!config.isDevelopment() && !isHttps) {
//            log.error("Signature URL must be over SSL: " + signatureURL);
//            return false;
//        } // end if

        String signatureValidation = getSignatureValidation(request);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(request.getJiveSignatureURL());
        AsyncInvoker invocation = target.request(MediaType.APPLICATION_JSON_TYPE)
                                      .header("X-Jive-MAC", request.getJiveSignature())
                                      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM)
                                      .async();

        Future<String> responseFuture = invocation.post(Entity.entity(signatureValidation, MediaType.APPLICATION_OCTET_STREAM),String.class);

        try {
            String response = responseFuture.get();
            if (log.isDebugEnabled()) { log.debug("Signature Validated ["+response+"]"); }
            return true;
        } catch (BadRequestException bre) {
            log.error("Error Validating Signature", bre);
        } catch (InterruptedException ie) {
            log.error("Error Validating Signature", ie);
        } catch (ExecutionException ee) {
            log.error("Error Validating Signature", ee);
        } // end try/catch

        return false;
    } // end isValidSignature


    private static String getSignatureValidation(JiveSignatureValidatable request) {

        SortedMap<String, String> sortedMap = request.getJiveSignatureMap();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null) {
                sb.append(key).append(':').append(value).append((char) 10);
            } // end if
        } // end for entry
        return sb.toString();

    } // end getSignatureValidation
    
} // end class

