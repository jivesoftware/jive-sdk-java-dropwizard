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

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Zvoykish
 * Date: 17/1/13
 * Time: 2:20 PM
 */
public class DateTimeUtils {
    private static final Logger log = LoggerFactory.getLogger(DateTimeUtils.class);
    private static final SimpleDateFormat tileDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    private static final SimpleDateFormat fullISODate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private static final SimpleDateFormat simpleISODate = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Converts an ISO date String to a Java date object.
     *
     * @param dateString The ISO date String
     * @return The matching date object
     * @throws IllegalArgumentException In case parsing failed
     */

    public static Date isoToDate(String dateString) {
        try {
            return fullISODate.parse(dateString);
        } catch (Exception e) {
            log.info("Failed converting ISO date string to date: " + dateString, e);
            return null;
        }
    }

    /**
     * Converts a Date to an ISO Date String
     *
     * @param date The date Object
     * @return The formatted ISO Date String
     * @throws IllegalArgumentException In case date is invalid
     */

    public static String dateToIso(Date date) {
        try {
            return fullISODate.format(date);
        } catch (Exception e) {
            log.info("Failed converting Date to ISO date string: " + date, e);
            return null;
        }
    }


    /**
     * Converts a Date to an ISO Date Time String compatible with Tiles
     *
     * @param date The date Object
     * @return The formatted ISO Date Time String for Tiles
     * @throws IllegalArgumentException In case date is invalid
     */

    public static String dateToTileIso(Date date) {
        try {
            return tileDateFormat.format(date);
        } catch (Exception e) {
            log.info("Failed converting Date to ISO date string: " + date, e);
            return null;
        }
    }

    /**
     * Converts simple date String (YYYY-MM-DD) to a Java date object.
     *
     * @param dateString The date String
     * @return The matching date object
     * @throws IllegalArgumentException In case parsing failed
     */
    public static Date simpleDateStringToDate(String dateString) {
        try {
            return simpleISODate.parse(dateString);
        } catch (Exception e) {
            log.info("Failed converting simple date string to date: " + dateString, e);
            return null;
        }
    }

} // end class