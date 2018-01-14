package com.yangli907.phome.dao;

import java.util.HashMap;
import java.util.Map;

import com.yangli907.phome.model.Review;

public class ReviewDao {
    public static Map<Integer, Review> reviews;

    static {
        reviews = new HashMap<>();

        reviews.put(1, new Review.ReviewBuilder().withId(1).withFromUser("yangli907").withToUser("cobblest").withScore(4).withText("awesome").build());
    }

    public static Review getReviewFromUser(String userId) {
        for(Review review : reviews.values()) {
            if(review.getFromUser().equals(userId)) {
                return review;
            }
        }

        return null;
    }

    public static Review getReviewToUser(String userId) {
        for(Review review : reviews.values()) {
            if(review.getToUser().equals(userId)) {
                return review;
            }
        }

        return null;
    }

    public static boolean updateReview(int reviewId, Review review) {
        if(reviews.containsKey(reviewId)) {
            reviews.put(reviewId, review);
            return true;
        }

        return false;
    }

    public static boolean deleteReview(int reviewId) {
        if(reviews.containsKey(reviewId)) {
            reviews.remove(reviewId);
            return true;
        }

        return false;
    }
}
