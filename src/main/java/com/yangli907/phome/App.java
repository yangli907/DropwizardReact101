package com.yangli907.phome;

import com.bendb.dropwizard.jooq.JooqBundle;
import com.bendb.dropwizard.jooq.JooqFactory;
import com.yangli907.phome.config.AppConfiguration;
import com.yangli907.phome.controller.PhotographerController;
import com.yangli907.phome.controller.ReviewController;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<AppConfiguration>
{
    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        super.initialize(bootstrap);

        bootstrap.addBundle(new JooqBundle<AppConfiguration>() {
            @Override
            public PooledDataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }

            @Override
            public JooqFactory getJooqFactory(AppConfiguration configuration) {
                return configuration.jooq();
            }
        });

        bootstrap.addBundle(new AssetsBundle("/assets", "/index", "index.html"));
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        //Guice.createInjector(new AppModule(configuration));
        environment.jersey().register(PhotographerController.class);
        environment.jersey().register(ReviewController.class);
    }

    public static void main(String args[]) throws Exception {
        new App().run(args);
    }
}
