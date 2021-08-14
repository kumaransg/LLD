package amazon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author priyamvora
 * @created 23/04/2021
 */
public class ShoppingCart {
    private List<ShoppingCartItem> shoppingCartItemList;

    public ShoppingCart() {
        this.shoppingCartItemList = new ArrayList<>();
    }

    public void addShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        this.shoppingCartItemList.add(shoppingCartItem);
    }

    public void removeProduct(String productId) {
        this.shoppingCartItemList = shoppingCartItemList.stream().filter(shoppingCartItem -> !shoppingCartItem.getProduct().getProductId().equals(productId)).collect(Collectors.toList());
    }

    public void decreaseQty(String productId) {
        Optional<ShoppingCartItem> shoppingCartItemOptional = shoppingCartItemList.stream().filter(shoppingCartItem -> shoppingCartItem.getProduct().getProductId().equals(productId)).findFirst();
        if (shoppingCartItemOptional.isPresent()) {
            shoppingCartItemOptional.get().setQty(shoppingCartItemOptional.get().getQty() - 1);
            shoppingCartItemOptional.get().setTotalPrice(shoppingCartItemOptional.get().getQty() * shoppingCartItemOptional.get().getProduct().getPrice());
        }
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCartItemList=" + shoppingCartItemList +
                '}';
    }
}
