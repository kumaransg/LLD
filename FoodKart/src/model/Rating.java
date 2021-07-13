package model;

import java.util.ArrayList;

public class Rating {
    private ArrayList<Comment> listOfComments;
    private ArrayList<Integer> listOfRatings;
    private int totalRatingSum;

    public Rating() {
        this.listOfComments = new ArrayList<>();
        listOfRatings = new ArrayList<>();
        totalRatingSum = 0;
    }

    public double getAverageRating() {
        return totalRatingSum / (listOfRatings.size() * 1.0);
    }

    public void addRatingAndComment(String userComment, int ratingScore) {
        Comment comment = new Comment(userComment);
        listOfComments.add(comment);
        listOfRatings.add(ratingScore);
        totalRatingSum += ratingScore;
    }
}
