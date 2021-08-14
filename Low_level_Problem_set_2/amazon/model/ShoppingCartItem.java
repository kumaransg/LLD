package amazon.model;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class ShoppingCartItem {
    private final Product product;
    private Integer qty;
    private Double totalPrice;

    public ShoppingCartItem(Product product, Integer qty) {
        this.product = product;
        this.qty = qty;
        this.totalPrice = product.getPrice() * qty;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQty() {
        return qty;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
