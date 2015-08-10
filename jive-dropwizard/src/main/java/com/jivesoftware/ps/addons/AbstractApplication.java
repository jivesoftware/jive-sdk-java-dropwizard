package com.jivesoftware.ps.addons;

import com.jivesoftware.ps.apps.App;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.HashSet;
import java.util.Set;

/**
 * An extension of the {@link Application} that allows Jive Add-Ons to be auto-registered.
 *
 * @author Jive Software
 * @since 1.0.0
 */
public abstract class AbstractApplication<T extends Configuration> extends Application<T> {

    protected final Set<App> registeredApps;

    /**
     * Creates an {@link Application} that locates Jive apps on the classpath
     */
    public AbstractApplication() {
        this.registeredApps = this.findApps();
    }

    /**
     * When the application runs, this is called after the {@link io.dropwizard.Bundle}s are run. Override it to add
     * providers, resources, etc. for your application.
     *
     * @param configuration the parsed {@link io.dropwizard.Configuration} object
     * @param environment   the application's {@link Environment}
     * @throws Exception if something goes wrong
     */
    @Override
    public void run(T configuration, Environment environment) throws Exception {
        this.onRun(configuration, environment);
        for (App app : registeredApps) {
            app.onRun(configuration, environment);
        }
    }

    /**
     * Initializes the application bootstrap.
     *
     * @param bootstrap the application bootstrap
     */
    @Override
    public void initialize(Bootstrap<T> bootstrap) {
        super.initialize(bootstrap);
        this.onInitialize(bootstrap);
        for (App app : registeredApps) {
            app.onInitialize(bootstrap);
        }
    }

    /**
     *
     * @param bootstrap pre-start application environment
     */
    public abstract void onInitialize(Bootstrap<T> bootstrap);

    /**
     *
     * @param configuration the parsed {@link io.dropwizard.Configuration} object
     * @param environment   the application's {@link Environment}
     * @throws Exception if something goes wrong
     */
    public abstract void onRun(Configuration configuration, Environment environment) throws Exception;

    /**
     * Locates classes that implement {@link App} that are on the classpath
     *
     * @return classes that implement {@link App} that are on the classpath
     */
    protected Set<App> findApps() {
        Set<App> discoveredApps = new HashSet<App>();
        return discoveredApps;
    }
}
