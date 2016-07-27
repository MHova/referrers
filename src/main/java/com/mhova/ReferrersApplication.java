package com.mhova;

import com.mhova.resources.ReferrersResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ReferrersApplication extends Application<ReferrersConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ReferrersApplication().run(args);
    }

    @Override
    public String getName() {
        return "Referrers";
    }

    @Override
    public void initialize(final Bootstrap<ReferrersConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ReferrersConfiguration configuration,
                    final Environment environment) {
        final ReferrersResource referrers = new ReferrersResource();
        environment.jersey().register(referrers);
    }

}
