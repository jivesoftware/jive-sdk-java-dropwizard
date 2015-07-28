package com.jivesoftware.sdk.services.jersey.filters;

import java.util.SortedMap;

/**
 * Created by rrutan on 3/12/14.
 */
public interface JiveSignatureValidatable {

    public String getJiveSignature();
    public String getJiveSignatureURL();
    public SortedMap<String,String> getJiveSignatureMap();

}