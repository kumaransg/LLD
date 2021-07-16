package io.abhi.cartdesign;

import java.util.List;

public class ApplicableOnAllItems extends Coupon {
  private double percent;

  public ApplicableOnAllItems(int id, String name, double percent) {
    super(id, name);
    this.percent = percent;
  }

  public double getPercent() {
    return percent;
  }

  public void setPercent(double percent) {
    this.percent = percent;
  }


  @Override public boolean equals(Coupon coupon) {
    return false;
  }

  @Override public void applyCoupon(List<Product> products) {
    for(Product p : products) {
      if (!p.isCoupon()) {
        double price = p.getPrice() - (p.getPrice() * this.percent) / 100;
        p.setPrice(price);
      }
    }
  }
}
