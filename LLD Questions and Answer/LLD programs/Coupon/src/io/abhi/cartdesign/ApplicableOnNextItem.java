package io.abhi.cartdesign;

import java.util.List;

public class ApplicableOnNextItem extends Coupon {
  private double percent;

  public ApplicableOnNextItem(int id, String name, double percent) {
    super(id, name);
    // super();
    this.percent = percent;
  }

  public double getPercent() {
    return percent;
  }

  public void setPercent(double percent) {
    this.percent = percent;
  }

  @Override public boolean equals(Coupon coupon) {
    if (this.getId() == coupon.getId()) return true;
    else return false;
  }

  @Override public void applyCoupon(List<Product> products) {
    boolean found = false;
    for(Product p : products) {
      if (p.isCoupon() && this.equals((Coupon) p)) {
        found = true;
      } else if (found == true && !p.isCoupon()) {
        double price = p.getPrice() - (p.getPrice() * percent) / 100;
        p.setPrice(price);
        break;
      }
    }
  }
}
