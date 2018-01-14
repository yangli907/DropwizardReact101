package com.yangli907.phome.controller;

import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.yangli907.phome.api.PhotographerApi;
import com.yangli907.phome.dao.PhotographerDao;
import com.yangli907.phome.model.Photographer;
import org.jooq.DSLContext;

@Path("/photographer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PhotographerController implements PhotographerApi {

    //TODO: integrate DAO with DI framework
    private PhotographerDao photographerDao;

    public PhotographerController(@Context DSLContext database) {
        this.photographerDao = new PhotographerDao(database);
    }

    @Override
    public Response getPhotographers() {
        return Response.ok(photographerDao.getPhotographers()).build();
    }

    @Override
    public Response getPhotographerByUserId(String userId) {
        Photographer photographer = photographerDao.getPhotographer(userId);

        if (photographer != null) {
           return Response.ok(photographer).build();
        }
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    public Response createPhotographer(Photographer photographer) throws URISyntaxException {
        String userId = photographer.getUserId();
        Photographer existingPhotographer = photographerDao.getPhotographer(userId);
        if (existingPhotographer == null) {
            photographerDao.updatePhotographer(userId, photographer);
            return Response.created(new URI("/photographer/" + photographer.getUserId())).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Override
    public Response updatePhotographerByUserId(String userId, Photographer photographer) {
        Photographer existingPhotographer = photographerDao.getPhotographer(userId);

        if (existingPhotographer != null) {
            photographer.setId(existingPhotographer.getId());
            photographerDao.updatePhotographer(existingPhotographer.getUserId(), photographer);
            return Response.ok(photographer).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
