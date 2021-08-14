package amazon;

import java.util.List;
public class Product {
    int id;
    String ImageURL;
    String descripton, name;
    double price;
    ProductCategory category;
    Seller seller;
    List<ProductReview> productReviews;
    
    public List<ProductReview> getProductReview(){
        return productReviews;
    }
    
    public void addProductReview(ProductReview pr) {
        
    }
}
