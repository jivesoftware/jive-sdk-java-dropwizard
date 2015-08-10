package com.jivesoftware.ps.customer.healthcheck;

import com.codahale.metrics.health.HealthCheck;

/**
 * Simple healthcheck that makes sure the Add-On is alive
 *
 * @see HealthCheck
 */
public class AddonAlive extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy("Add-On is up and working");
    }
}
