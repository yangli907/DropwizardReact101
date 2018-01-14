package com.yangli907.phome.api;

import java.net.URISyntaxException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.yangli907.phome.model.Photographer;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/photographer")
public interface PhotographerApi {
    @GET
    Response getPhotographers();

    @GET
    @Path("/{userId}")
    Response getPhotographerByUserId(@PathParam("userId") String userId);

    @POST
    Response createPhotographer(Photographer photographer) throws URISyntaxException;

    @PUT
    @Path("/{userId}")
    Response updatePhotographerByUserId(@PathParam("userId") String userId, Photographer photographer);
}
