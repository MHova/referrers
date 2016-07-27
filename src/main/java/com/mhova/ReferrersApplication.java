package com.mhova;

import org.skife.jdbi.v2.DBI;

import com.mhova.handlers.ReferrerHandler;
import com.mhova.resources.ReferrersResource;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
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
        bootstrap.addBundle(new MigrationsBundle<ReferrersConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(final ReferrersConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(final ReferrersConfiguration configuration,
                    final Environment environment) {

        final DBI jdbi = new DBIFactory().build(environment, configuration.getDataSourceFactory(), "referrers-db");
        environment.jersey().register(new ReferrersResource(new ReferrerHandler()));
    }

}
