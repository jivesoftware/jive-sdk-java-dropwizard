package com.jivesoftware.addons.example;

import com.jivesoftware.addons.example.resources.InstanceResource;
import com.jivesoftware.addons.example.resources.TileResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ExampleAddonApplication extends Application<ExampleAddonConfiguration> {
    public static void main(String[] args) throws Exception {
        new ExampleAddonApplication().run(args);
    }

    @Override
    public String getName() {
        return "example-addon";
    }

    @Override
    public void initialize(Bootstrap<ExampleAddonConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets", "/"));
        bootstrap.addBundle(new AssetsBundle("/assets/css", "/assets/css", null, "assets/css"));
        bootstrap.addBundle(new AssetsBundle("/assets/js", "/js", null, "js"));
        bootstrap.addBundle(new AssetsBundle("/assets/fonts", "/assets/css/fonts", null, "assets/css/fonts"));
    }

    @Override
    public void run(ExampleAddonConfiguration exampleAddonConfiguration, Environment environment) throws Exception {
        final InstanceResource instanceResource = new InstanceResource();
        final TileResource tileResource = new TileResource();

        environment.jersey().register(instanceResource);
        environment.jersey().register(tileResource);
    }
}
