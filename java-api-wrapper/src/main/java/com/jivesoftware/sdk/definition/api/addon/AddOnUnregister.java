package com.jivesoftware.sdk.definition.api.addon;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddOnUnregister implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3400228478789301273L;
	
	private String timestamp;
    private String jiveUrl;
    private String jiveSignatureURL;
    private String tenantId;
    private String jiveSignature;
    private boolean uninstalled;
    private String clientId;
    
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getJiveUrl() {
		return jiveUrl;
	}
	public void setJiveUrl(String jiveUrl) {
		this.jiveUrl = jiveUrl;
	}
	public String getJiveSignatureURL() {
		return jiveSignatureURL;
	}
	public void setJiveSignatureURL(String jiveSignatureURL) {
		this.jiveSignatureURL = jiveSignatureURL;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getJiveSignature() {
		return jiveSignature;
	}
	public void setJiveSignature(String jiveSignature) {
		this.jiveSignature = jiveSignature;
	}
	public boolean isUninstalled() {
		return uninstalled;
	}
	public void setUninstalled(boolean uninstalled) {
		this.uninstalled = uninstalled;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
    
} // end class
