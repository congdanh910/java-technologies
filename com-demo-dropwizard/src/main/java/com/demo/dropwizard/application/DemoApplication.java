package com.demo.dropwizard.application;

import com.demo.dropwizard.config.DemoConfiguration;
import com.demo.dropwizard.dao.StaffDAO;
import com.demo.dropwizard.model.Staff;
import com.demo.dropwizard.resource.DemoResource;
import com.demo.dropwizard.resource.StaffResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

/**
 * Created by CongDanh on 8/27/15.
 */
public class DemoApplication extends Application<DemoConfiguration> {

    public static void main(String args[]) throws Exception {
        new DemoApplication().run(args);
    }

    @Override
    public void run(DemoConfiguration configuration, Environment environment) throws Exception {

        // declare database configuration
        final DBIFactory dbiFactory = new DBIFactory();
        final DBI dbi = dbiFactory.build(environment, configuration.getDataSourceFactory(), "mysql");
        final StaffDAO staffDAO = dbi.onDemand(StaffDAO.class);
        // declare resources
        final DemoResource demoResource = new DemoResource(configuration.getTemplate(), configuration.getDefaultName());
        final StaffResource staffResource = new StaffResource(staffDAO);
        environment.jersey().register(demoResource);
        environment.jersey().register(staffResource);
    }
}
