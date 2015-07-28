package com.jivesoftware.sdk.definition.api.addon;

import java.io.Serializable;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jivesoftware.sdk.services.jersey.filters.JiveSignatureValidatable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddOnRegister implements Serializable, JiveSignatureValidatable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6055870307062533642L;
	
	public final static String TENANT_ID = "tenantId";
    public final static String JIVE_SIGNATURE_URL = "jiveSignatureURL";
    public final static String TIMESTAMP = "timestamp";
    public final static String JIVE_URL = "jiveUrl";
    public final static String JIVE_SIGNATURE = "jiveSignature";
    public final static String SCOPE = "scope";
    public final static String CODE = "code";
    public final static String CLIENT_SECRET = "clientSecret";
    public final static String CLIENT_ID = "clientId";
	
    private String tenantId;
    private String jiveSignatureURL;
    private String timestamp;
    private String jiveUrl;
    private String jiveSignature;
    private String scope;
    private String code;
    private String clientSecret;
    private String clientId;
    
    public SortedMap<String, String> getJiveSignatureMap() {
        // Encode the client-secret
        String encodedClientSecret = (clientSecret != null) ? DigestUtils.sha256Hex(clientSecret) : clientSecret;
        SortedMap<String, String> sortedMap = new TreeMap<String,String>();
        sortedMap.put(CLIENT_ID, clientId);
        sortedMap.put(CLIENT_SECRET, encodedClientSecret);
        sortedMap.put(CODE, code);
        sortedMap.put(JIVE_SIGNATURE_URL, jiveSignatureURL);
        sortedMap.put(JIVE_URL, jiveUrl);
        sortedMap.put(SCOPE, scope);
        sortedMap.put(TENANT_ID, tenantId);
        sortedMap.put(TIMESTAMP, timestamp);
        return sortedMap;
    } // end getJiveSignatureMap

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getJiveSignatureURL() {
		return jiveSignatureURL;
	}

	public void setJiveSignatureURL(String jiveSignatureURL) {
		this.jiveSignatureURL = jiveSignatureURL;
	}

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

	public String getJiveSignature() {
		return jiveSignature;
	}

	public void setJiveSignature(String jiveSignature) {
		this.jiveSignature = jiveSignature;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
   
} // end class