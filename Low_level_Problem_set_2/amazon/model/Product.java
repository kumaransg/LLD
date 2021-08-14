package amazon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author priyamvora
 * @created 23/04/2021
 */
public class Product {
    private final String productId;
    private String name;
    private Category category;
    private Double price;
    private List<ReviewRating> reviewRatingList;
    private Integer availableItems;

    public Product(String name, Category category, Double price, Integer availableItems) {
        this.productId = UUID.randomUUID().toString();
        this.name = name;
        this.category = category;
        this.price = price;
        this.reviewRatingList = new ArrayList<>();
        this.availableItems = availableItems;
    }

    public void addReviewRating(ReviewRating reviewRating) {
        reviewRatingList.add(reviewRating);
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public List<ReviewRating> getReviewRatingList() {
        return reviewRatingList;
    }

    public void removeReviewRating(String reviewRatingId) {
        this.reviewRatingList = reviewRatingList.stream().filter(reviewRating -> !reviewRating.getReviewRatingId().equals(reviewRatingId)).collect(Collectors.toList());
    }

    public Integer getAvailableItems() {
        return availableItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setReviewRatingList(List<ReviewRating> reviewRatingList) {
        this.reviewRatingList = reviewRatingList;
    }

    public void setAvailableItems(Integer availableItems) {
        this.availableItems = availableItems;
    }
}
