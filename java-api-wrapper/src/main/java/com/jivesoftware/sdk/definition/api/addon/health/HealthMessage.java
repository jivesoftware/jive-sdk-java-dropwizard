package com.jivesoftware.sdk.definition.api.addon.health;

import java.io.Serializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class HealthMessage implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6026223889632000769L;

	@JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private String level;

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private String summary;

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private String detail;

    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    private String fix;

    enum Level {
        debug, info, warn, error
    }

} // end class
