package com.jivesoftware.ps.customer;

import com.jivesoftware.ps.addons.AbstractApplication;
import com.jivesoftware.ps.customer.healthcheck.AddonAlive;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 *
 *
 * @see AbstractApplication
 * @see Configuration
 */
public class JiveAddOn extends AbstractApplication<Configuration> {

    /**
     * Returns the name of the application.
     *
     * @return the application's name
     */
    @Override
    public String getName() {
        return "Jive Example Add-On";
    }

    /**
     * @param bootstrap pre-start application environment
     */
    @Override
    public void onInitialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }

    /**
     * @param configuration the parsed {@link Configuration} object
     * @param environment   the application's {@link Environment}
     * @throws Exception if something goes wrong
     */
    @Override
    public void onRun(Configuration configuration, Environment environment) throws Exception {
        environment.healthChecks().register("live", new AddonAlive());
        environment.jersey().setUrlPattern("/api/*");
    }

    public static void main(String[] args) throws Exception {
        new JiveAddOn().run(args);
    }
}
