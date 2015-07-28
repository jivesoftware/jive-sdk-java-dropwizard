package com.jivesoftware.sdk.definition.api.addon.health;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by rrutan on 2/6/14.
 */

@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class HealthStatus implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6122888502714504343L;

	@JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private String status;

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private String lastUpdate;

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private List<HealthMessage> messages;

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private List<HealthResource> resources;

    enum Status {
        ok, fault, unknown, intermittent, maintenance;
    }

    public HealthStatus() {
        status = null;
        lastUpdate = null;
        messages = new ArrayList<HealthMessage>();
        resources = new ArrayList<HealthResource>();
    } // end constructor

} // end class
