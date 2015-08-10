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
package com.jivesoftware.ps.hello;

import com.jivesoftware.ps.apps.App;
import com.jivesoftware.ps.hello.resources.HelloWorld;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Starting class for the Hello App.
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
