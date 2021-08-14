package amazon.model;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 23/04/2021
 */
public class ReviewRating {
    private String reviewRatingId;
    private String review;
    private Double rating;
    private final String userId;

    public ReviewRating(Double rating, String userId) {
        this.reviewRatingId = UUID.randomUUID().toString();
        this.rating = rating;
        this.userId = userId;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public Double getRating() {
        return rating;
    }

    public String getUserId() {
        return userId;
    }

    public String getReviewRatingId() {
        return reviewRatingId;
    }
}
