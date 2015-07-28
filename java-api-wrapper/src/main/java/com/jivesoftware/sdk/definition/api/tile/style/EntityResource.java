package com.jivesoftware.sdk.definition.api.tile.style;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Data class for a generic resource entry in jive objects
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class EntityResource {
    private List<String> allowed;
    private String ref;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public List<String> getAllowed() {
        return allowed;
    }

    public void setAllowed(List<String> allowed) {
        this.allowed = allowed;
    }
}
