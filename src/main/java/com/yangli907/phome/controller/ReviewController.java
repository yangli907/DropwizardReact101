package com.yangli907.phome.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yangli907.phome.api.ReviewApi;
import com.yangli907.phome.dao.ReviewDao;
import com.yangli907.phome.model.Review;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/review")
public class ReviewController implements ReviewApi {
    @Override
    public Review getReviewFromUser(String userId) {
        return ReviewDao.getReviewFromUser(userId);
    }

    @Override
    public Review getReviewToUser(String userId) {
        return ReviewDao.getReviewToUser(userId);
    }

    @Override
    public boolean updateReview(int reviewId, Review review) {
        return ReviewDao.updateReview(reviewId, review);
    }

    @Override
    public boolean deleteReview(int reviewId) {
        return ReviewDao.deleteReview(reviewId);
    }
}
