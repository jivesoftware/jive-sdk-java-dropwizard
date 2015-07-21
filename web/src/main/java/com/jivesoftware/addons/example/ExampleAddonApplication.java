package com.jivesoftware.addons.example;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.jivesoftware.addons.example.services.InstanceService;
import com.jivesoftware.addons.example.services.TileService;

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
        /*** ARE ALL THESE NEEDED?  ISN'T IT IMPLIED THAT /assets IS RECURSIVELY DECLARED???? ***/
        bootstrap.addBundle(new AssetsBundle("/assets/css", "/assets/css", null, "assets/css"));
        bootstrap.addBundle(new AssetsBundle("/assets/js", "/js", null, "js"));
        bootstrap.addBundle(new AssetsBundle("/assets/fonts", "/assets/css/fonts", null, "assets/css/fonts"));
        bootstrap.addBundle(new AssetsBundle("/assets/images", "/assets/images", null, "assets/images"));
        bootstrap.addBundle(new AssetsBundle("/assets/apps", "/assets/apps", null, "assets/apps"));
        bootstrap.addBundle(new AssetsBundle("/assets/addon", "/assets/addon", null, "assets/addon"));
        
        //TODO:  IT WOULD BE INTERESTING TO SEE IF YOU COULD CREATE A VIRTUAL PATH IN APPS THAT WOULD SERVE images/xyz.png REQUESTS FROM A GLOBAL DIRECTORY
    }

    @Override
    public void run(ExampleAddonConfiguration exampleAddonConfiguration, Environment environment) throws Exception {
    	
    	//TODO: CONFIRM THAT JACKSON IS ALREADY REGISTERED?
    	
    	// CONVERTS properties like "abc_def to abcDef" for Mapping ... Could help with the number of @JsonProperty annotations
    	//environment.getObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    	
    	

        final InstanceService instanceService = new InstanceService();
        final TileService tileService = new TileService();

        environment.jersey().register(instanceService);
        environment.jersey().register(tileService);
    }
}
