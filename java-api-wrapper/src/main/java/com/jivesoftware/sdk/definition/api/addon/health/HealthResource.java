package com.jivesoftware.sdk.definition.api.addon.health;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class HealthResource implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7650400630832666873L;

	@JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private String name;

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private String url;

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private String status;

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private String lastUpdate;

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private List<HealthMessage> messages;

    public HealthResource() {
        this.name = null;
        this.url = null;
        this.status = null;
        this.lastUpdate = null;
        this.messages = new ArrayList<HealthMessage>();
    } // end constructor
    
} // end class
