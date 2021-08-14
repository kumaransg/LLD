package io.abhi.cartdesign;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  private List<Product> products;
  public Cart() {
   products = new ArrayList<>();
  }

  public double getPrice() {
    double totalPrice = 0;
    products.forEach(prod -> {
      if (prod.isCoupon()) {
        Coupon cp = (Coupon) prod;
        cp.applyCoupon(products);
      }
    });
    for(Product p : products) {
       // System.out.println(p.getId() + " " + p.getPrice());
        totalPrice += p.getPrice();
    }
    return totalPrice;
  }
  public void addProduct(Product product) {

    products.add(product);
  }

  // p1, p2, c1, c3, p3, c2, p4,
  public static void main(String[] args) {
    Product it1 = new Item(1, "black Tshirt", Cateogry.TSHIRT, 100.00);
    Product it2 = new Item(2, "white Jeans", Cateogry.JEANS, 150.00);
    Product it3 = new Item(6, "white Tshirt", Cateogry.JEANS, 200.00);
    Product cp1 = new ApplicableOnAllItems(3, "cp1", 10.00);
    Product cp2 = new ApplicableOnNextItem(4, "cp2", 20.00);
    Product cp3 = new ApplicableOnCateogry(5, "cp3", 20.00, Cateogry.JEANS, 2);
    Cart cart = new Cart();
    cart.addProduct(it1);
    cart.addProduct(cp1);
    cart.addProduct(cp2);
    cart.addProduct(it2);
    cart.addProduct(cp3);
    cart.addProduct(it3);
    System.out.println("Price is " + cart.getPrice());

  }
}

// c1 - apply coupon
// c2 - not used, use it;
// c3 - Nth item of Type t.


