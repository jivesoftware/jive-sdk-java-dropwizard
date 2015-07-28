package com.jivesoftware.sdk.definition.api.webhook;

import java.io.Serializable;
import java.util.Map;

import com.jivesoftware.sdk.definition.api.JiveResource;

public class WebhookRegister implements Serializable, BaseWebhook  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9202409672547770098L;
	private long id;
	private Map<String,JiveResource> resources;
	private String object;
	private String callback;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Map<String, JiveResource> getResources() {
		return resources;
	}
	public void setResources(Map<String, JiveResource> resources) {
		this.resources = resources;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	
	

}
