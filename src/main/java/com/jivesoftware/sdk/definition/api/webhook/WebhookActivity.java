package com.jivesoftware.sdk.definition.api.webhook;

import java.io.Serializable;

import com.jivesoftware.sdk.definition.api.JiveActivity;

public class WebhookActivity implements Serializable, BaseWebhook {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1521061689243574347L;
	
	private String webhook;
	private JiveActivity jive;
	
	public String getWebhook() {
		return webhook;
	}
	public void setWebhook(String webhook) {
		this.webhook = webhook;
	}
	public JiveActivity getJive() {
		return jive;
	}
	public void setJive(JiveActivity jive) {
		this.jive = jive;
	}
	
} // end class