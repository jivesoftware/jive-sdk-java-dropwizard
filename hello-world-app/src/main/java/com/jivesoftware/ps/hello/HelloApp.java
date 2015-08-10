package com.jivesoftware.ps.hello;

import com.jivesoftware.ps.apps.App;
import com.jivesoftware.ps.hello.resources.HelloWorld;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 *
 *
 * @see App
 */
public class HelloApp implements App<Configuration>{

    /**
     * Returns the name assigned to the app
     *
     * @return the name assigned to the app
     */
    @Override
    public String getName() {
        return "Hello World App";
    }

    /**
     * Called from the addon during the application setup process
     *
     * @param configuration object representation of the YAML configuration file
     * @param environment   Dropwizard application's environment
     * @throws Exception thrown if there are any problems
     */
    @Override
    public void onRun(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(new HelloWorld());
    }

    /**
     * Called from the addon during the application's initialization process
     *
     * @param bootstrap pre-start application environment
     */
    @Override
    public void onInitialize(Bootstrap<Configuration> bootstrap) {

    }
}
