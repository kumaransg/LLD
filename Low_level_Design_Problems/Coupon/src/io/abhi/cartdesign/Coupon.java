package io.abhi.cartdesign;

import java.util.List;

public abstract class Coupon extends Product {
  private int id;
  private String name;
  public Coupon(int id, String name) {
    super(id, name, 0);
  }

  @Override
  public boolean isCoupon() {
    return true;
  }
  public abstract boolean equals(Coupon coupon);
  public abstract void applyCoupon(List<Product> products);

}


/*
Items {
  int id;
  price,
  Type,
  name,
}

Coupon {
  int id;
  int percentageOff,
  int dollarOff,
  apliedOnNextItem, -- expired
  appiledToAllItem, isExpired,
  particularTypewithNumber - expired
}

List<Item>
List<Coupon>
Item ->

it1, it2, c1, c2, c3, c3, it3

*/
