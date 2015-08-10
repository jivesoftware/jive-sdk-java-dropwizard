/*
 * Copyright (C) 2015 Jive Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jivesoftware.ps.customer;

import com.jivesoftware.ps.addons.AbstractApplication;
import com.jivesoftware.ps.customer.healthcheck.AddonAlive;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Start up class for the example Add-On.
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
