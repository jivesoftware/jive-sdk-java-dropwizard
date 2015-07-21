package com.jivesoftware.sdk.definition.api.tile;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TileRegister implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 691322392938389481L;

	private String code;
    private Map<String, String> config = null;
    private String url;
    private String jiveUrl;
    private String parent;
    private String guid;
    private String placeUri;
    private String tenantID;
    private String name;
    private String id;
    
    public TileRegister() {
    	config = new HashMap<String,String>();
    } // end constructor

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<String, String> getConfig() {
		return config;
	}

	public void setConfig(Map<String, String> config) {
		this.config = config;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getJiveUrl() {
		return jiveUrl;
	}

	public void setJiveUrl(String jiveUrl) {
		this.jiveUrl = jiveUrl;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getPlaceUri() {
		return placeUri;
	}

	public void setPlaceUri(String placeUri) {
		this.placeUri = placeUri;
	}

	public String getTenantID() {
		return tenantID;
	}

	public void setTenantID(String tenantID) {
		this.tenantID = tenantID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

} // end class
