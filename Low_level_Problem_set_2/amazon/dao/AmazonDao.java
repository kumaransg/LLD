package amazon.dao;

import amazon.constants.ShippingStatus;
import amazon.model.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class AmazonDao {
    private List<Product> products;
    private final List<Category> categories;
    private final Map<String, List<Product>> categoryProductMap;
    private final Map<String, ShoppingCart> userToShoppingCartMap;
    private final Map<String, List<Order>> userToOrdersMap;
    private final Map<String, List<PaymentInfo>> userToPaymentsMap;

    public AmazonDao() {
        this.products = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.categoryProductMap = new HashMap<>();
        this.userToShoppingCartMap = new HashMap<>();
        this.userToOrdersMap = new HashMap<>();
        this.userToPaymentsMap = new HashMap<>();
    }

    public Product getProduct(String productId) {
        Optional<Product> productOptional = this.products.stream().filter(product -> product.getProductId().equals(productId)).findFirst();
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        return null;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        List<Product> currentMapping = categoryProductMap.getOrDefault(product.getCategory(), new ArrayList<>());
        currentMapping.add(product);
        categoryProductMap.put(product.getCategory().getCategory(), currentMapping);
    }

    public void removeProduct(String productId) {
        this.products = products.stream().filter(product -> !product.getProductId().equals(productId)).collect(Collectors.toList());
    }

    public void modifyProduct(Product updatedProduct) {
        Optional<Product> originalProduct = products.stream().filter(product -> product.getProductId().equals(updatedProduct.getProductId())).findFirst();
        originalProduct.ifPresent(product -> updateProduct(product, updatedProduct));
    }

    private void updateProduct(Product originalProduct, Product updatedProduct) {
        if (!originalProduct.getCategory().getCategory().equals(updatedProduct.getCategory().getCategory())) {
            List<Product> categoryProduct = categoryProductMap.getOrDefault(originalProduct.getCategory().getCategory(), new ArrayList<>());
            Product finalOriginalProduct = originalProduct;
            categoryProduct = categoryProduct.stream().filter(product -> !product.getProductId().equals(finalOriginalProduct.getProductId())).collect(Collectors.toList());
            categoryProductMap.put(originalProduct.getCategory().getCategory(), categoryProduct);
            List<Product> updatedCategoryProduct = categoryProductMap.getOrDefault(updatedProduct.getCategory().getCategory(), new ArrayList<>());
            updatedCategoryProduct.add(updatedProduct);
            categoryProductMap.put(updatedProduct.getCategory().getCategory(), updatedCategoryProduct);
        }
        originalProduct = updatedProduct;
    }

    public void addCategory(Category category) {
        categories.add(category);
        categoryProductMap.put(category.getCategory(), new ArrayList<>());
    }

    public void removeCategory(Category category) {
        categoryProductMap.remove(category.getCategory());
    }

    public void addProductToShoppingCart(String userId, ShoppingCartItem shoppingCartItem) {
        ShoppingCart shoppingCart = userToShoppingCartMap.getOrDefault(userId, new ShoppingCart());
        shoppingCart.addShoppingCartItem(shoppingCartItem);
        userToShoppingCartMap.put(userId, shoppingCart);
    }

    public void removeProductFromShoppingCart(String userId, String productId) {
        ShoppingCart shoppingCart = userToShoppingCartMap.getOrDefault(userId, new ShoppingCart());
        shoppingCart.removeProduct(productId);
        userToShoppingCartMap.put(userId, shoppingCart);
    }

    public void decreaseQtyFromShoppingCart(String userId, String productId) {
        ShoppingCart shoppingCart = userToShoppingCartMap.getOrDefault(userId, new ShoppingCart());
        shoppingCart.decreaseQty(productId);
        userToShoppingCartMap.put(userId, shoppingCart);
    }

    public void addReviewRatingToProduct(String productId, ReviewRating reviewRating) {
        Optional<Product> productOptional = products.stream().filter(product -> product.getProductId().equals(productId)).findFirst();
        productOptional.ifPresent(product -> product.addReviewRating(reviewRating));
    }

    public void removeReviewRatingFromProduct(String productId, String reviewRatingId) {
        Optional<Product> productOptional = products.stream().filter(product -> product.getProductId().equals(productId)).findFirst();
        productOptional.ifPresent(product -> product.setReviewRatingList(product.getReviewRatingList().stream().filter(reviewRating -> !reviewRating.getReviewRatingId().equals(reviewRatingId)).collect(Collectors.toList())));
    }

    public void addOrderForUser(Order order, String userId) {
        List<Order> orderList = userToOrdersMap.getOrDefault(userId, new ArrayList<>());
        orderList.add(order);
        userToOrdersMap.put(userId, orderList);
    }

    public void changeStatusOfOrderForUser(String userId, String orderId, ShippingStatus shippingStatus) {
        List<Order> orderList = userToOrdersMap.getOrDefault(userId, new ArrayList<>());
        Optional<Order> orderOptional = orderList.stream().filter(order -> order.getOrderId().equals(orderId)).findFirst();
        orderOptional.ifPresent(order -> order.setShippingStatus(shippingStatus));
    }

    public void addPaymentInfo(String userId, PaymentInfo paymentInfo) {
        List<PaymentInfo> payments = userToPaymentsMap.getOrDefault(userId, new ArrayList<>());
        payments.add(paymentInfo);
    }

    public List<PaymentInfo> getPaymentsForUser(String userId) {
        return userToPaymentsMap.getOrDefault(userId, new ArrayList<>());
    }


}
