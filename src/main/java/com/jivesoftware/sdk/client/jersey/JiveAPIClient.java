/*
 *
 *  * Copyright 2013 Jive Software
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *       http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */

package com.jivesoftware.sdk.client.jersey;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rrutan on 2/8/14.
 */
public class JiveAPIClient extends BaseJiveClient {
    private static final Logger log = LoggerFactory.getLogger(JiveAPIClient.class);

    public Object get(URI uri,JiveAuthorizationSupport authorization, Map<String,String> additionalHeaders, JiveRunAs runAs) throws JiveClientException {
    	return call(HttpMethod.GET,uri,MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON,null,authorization,runAs,additionalHeaders,null);
    } // end call
    
    public Object head(URI uri,JiveAuthorizationSupport authorization, Map<String,String> additionalHeaders, JiveRunAs runAs) throws JiveClientException {
    	return call(HttpMethod.HEAD,uri,MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON,null,authorization,runAs,additionalHeaders,null);
    } // end head
    
    public Object post(URI uri,Object data,JiveAuthorizationSupport authorization, Map<String,String> additionalHeaders, JiveRunAs runAs) throws JiveClientException {
    	return call(HttpMethod.POST,uri,MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON,data,authorization,runAs,additionalHeaders,null);
    } // end post
    
    public Object post(URI uri,String requestContentType, Object data,JiveAuthorizationSupport authorization, Map<String,String> additionalHeaders, JiveRunAs runAs) throws JiveClientException {
    	return call(HttpMethod.POST,uri,requestContentType,MediaType.APPLICATION_JSON,data,authorization,runAs,additionalHeaders,null);
    } // end post
    
    public Object put(URI uri,Object data,JiveAuthorizationSupport authorization, Map<String,String> additionalHeaders, JiveRunAs runAs) throws JiveClientException {
    	return call(HttpMethod.PUT,uri,MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON,data,authorization,runAs,additionalHeaders,null);
    } // end put
    
    public Object put(URI uri,String requestContentType, Object data,JiveAuthorizationSupport authorization, Map<String,String> additionalHeaders, JiveRunAs runAs) throws JiveClientException {
    	return call(HttpMethod.PUT,uri,requestContentType,MediaType.APPLICATION_JSON,data,authorization,runAs,additionalHeaders,null);
    } // end put
    
    public Object patch(URI uri,Object data,JiveAuthorizationSupport authorization, Map<String,String> additionalHeaders, JiveRunAs runAs) throws JiveClientException {
    	return call("PATCH",uri,MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON,data,authorization,runAs,additionalHeaders,null);
    } // end patch
    
    public Object patch(URI uri,String requestContentType, Object data,JiveAuthorizationSupport authorization, Map<String,String> additionalHeaders, JiveRunAs runAs) throws JiveClientException {
    	return call("PATCH",uri,requestContentType,MediaType.APPLICATION_JSON,data,authorization,runAs,additionalHeaders,null);
    } // end patch

    public Object call (String method, URI uri, String requestContentType, String responseContentType, Object data,
                        JiveAuthorizationSupport authorization, JiveRunAs runAs, Map<String,String> additionalHeaders, Class clazz) throws JiveClientException {

        /**** NEED TO MAKE SURE ****/
        if (requestContentType == null) {
            requestContentType = MediaType.APPLICATION_JSON;
        } // end if

        if (clazz == null) {
            clazz = Object.class;
        } // end if

        Client client = buildClient();

        WebTarget target = client.target(uri);

        AsyncInvoker invoker = getAsyncInvoker(target, requestContentType, authorization, runAs,additionalHeaders);

        Future<Object> responseFuture = null;

        if (data != null) {
            Entity entity = Entity.entity(data, MediaType.APPLICATION_JSON_TYPE);
            responseFuture = invoker.method(method,entity,clazz);
        } else {
            responseFuture = invoker.method(method,clazz);
        } // end if
        
        Object response = null;

        try {
            response = responseFuture.get();

            //TODO: DETERMINE STATUS CODE??

            if (log.isInfoEnabled()) { log.info("Successful Called ["+uri+"] ..."); }
            return response;
        } catch (BadRequestException bre) {
            log.error("Error Calling API [" + uri + "]", bre);
            throw JiveClientException.buildException("Error Calling API [" + uri + "]",bre,null,data,data.getClass());
        } catch (InterruptedException ie) {
            log.error("Error Calling API [" + uri + "]", ie);
            throw JiveClientException.buildException("Error Calling API [" + uri + "]",ie,null,data,data.getClass());
        } catch (ExecutionException ee) {
            log.error("Error Calling API [" + uri + "]", ee);
            throw JiveClientException.buildException("Error Calling API [" + uri + "]",ee,null,data,data.getClass());
        } // end try/catch

    } // end call

} // end class
