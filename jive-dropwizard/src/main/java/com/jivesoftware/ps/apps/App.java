package com.jivesoftware.ps.apps;

import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Public contract for a class that interface a Jive app into the Dropwizard.io
 * way of building an Add-On. Implementation of this interface will be called
 * when the Add-On is initializing so that the app can do any initialization
 * it needs to do.
 *
 * @author Jive Software
 * @since 1.0.0
 */
public interface App<T extends Configuration> {

    /**
     * Returns the name assigned to the app
     * @return the name assigned to the app
     */
    String getName();

    /**
     * Called from the addon during the application setup process
     *
     * @param configuration object representation of the YAML configuration file
     * @param environment Dropwizard application's environment
     * @throws Exception thrown if there are any problems
     */
    void onRun(T configuration, Environment environment) throws Exception;

    /**
     * Called from the addon during the application's initialization process
     *
     * @param bootstrap pre-start application environment
     */
    void onInitialize(Bootstrap<T> bootstrap);
}
