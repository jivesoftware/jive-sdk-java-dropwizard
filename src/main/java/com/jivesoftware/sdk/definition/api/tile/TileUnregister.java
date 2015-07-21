package com.jivesoftware.sdk.definition.api.tile;

import java.io.Serializable;

public class TileUnregister implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3166401726602858014L;
	
	private String name;
    private String jiveUrl;
    private String url;
    private String guid;
    private String tenantID;
    private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJiveUrl() {
		return jiveUrl;
	}
	public void setJiveUrl(String jiveUrl) {
		this.jiveUrl = jiveUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getTenantID() {
		return tenantID;
	}
	public void setTenantID(String tenantID) {
		this.tenantID = tenantID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    
    

} // end class
