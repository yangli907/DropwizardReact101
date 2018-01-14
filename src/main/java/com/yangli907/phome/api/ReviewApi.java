package com.yangli907.phome.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yangli907.phome.model.Review;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/review")
public interface ReviewApi {
    @GET
    @Path("/from/{userId}")
    Review getReviewFromUser(@PathParam("userId") String userId);

    @GET
    @Path("/to/{userId}")
    Review getReviewToUser(@PathParam("userId") String userId);

    @PUT
    @Path("/{reviewId}")
    boolean updateReview(@PathParam("reviewId") int reviewId, Review review);

    @DELETE
    @Path("/{reviewId}")
    boolean deleteReview(@PathParam("reviewId") int reviewId);
}
