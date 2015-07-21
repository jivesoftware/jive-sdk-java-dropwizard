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

package com.jivesoftware.sdk.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by rrutan on 1/30/14.
 */
public class JiveSDKUtils {
    private static final Logger log = LoggerFactory.getLogger(JiveSDKUtils.class);

    public static String encodeUrl(String url) {
        try {
            return URLEncoder.encode(url,StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException uee) {
        	log.warn("Failed encoding URL using UTF-8 charset" + uee.getMessage());
            //noinspection deprecation
            return url;
        } // end try/catch
    } // encodeUrl

    public static String decodeUrl(String url) {
        try {
            return URLDecoder.decode(url,StandardCharsets.UTF_8.name());
        }
        catch (UnsupportedEncodingException uee) {
            //TODO: LOGGER
            System.err.println("Failed decoding URL using UTF-8 charset" + uee.getMessage());
            //noinspection deprecation
            return url;
        }
    }

    /**
     * Check if all the items are presented and not empty
     *
     * @param items : Checked items
     * @return :
     * true -> if all the items are presented.
     * false -> if at least one is absent or empty.
     */
    public static boolean isAllExist(Object... items) {
        if (items == null) {
            return false;
        }

        for (Object item : items) {
            if (item == null || item.toString().isEmpty()) {
                return false;
            }
        }

        return true;
    }
    
    public static String getJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (IOException ioe) {
            log.error("Unknown Error",ioe);
        } // end try/catch
        return null;
    } // end getJson

} // end class
