package com.yangli907.phome.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.bendb.dropwizard.jooq.JooqFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class AppConfiguration extends Configuration {
    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    @NotNull
    private JooqFactory jooq = new JooqFactory(); // Defaults are acceptable

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dbFactory) {
        this.database = dbFactory;
    }

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    public JooqFactory jooq() {
        return jooq;
    }
}
