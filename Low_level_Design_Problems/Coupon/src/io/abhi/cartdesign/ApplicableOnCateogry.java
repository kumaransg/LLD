package io.abhi.cartdesign;

import java.util.List;

public class ApplicableOnCateogry extends Coupon {
  private double amount;
  private Cateogry cateogryType;
  private int countOfItem;

  public ApplicableOnCateogry(int id, String name, double amount, Cateogry cateogryType, int countOfItem) {
    super(id, name);
    this.amount = amount;
    this.cateogryType = cateogryType;
    this.countOfItem = countOfItem;
  }

  @Override public boolean equals(Coupon coupon) {
    return false;
  }

  @Override public void applyCoupon(List<Product> products) {
    int cnt = 0;
    for(Product p : products) {
      if (!p.isCoupon()) {
        Item item = (Item) p;
        if (this.getCateogryType().equals(item.getCateogryName())) cnt++;
        if (this.getCountOfItem() == cnt) {
          double price = p.getPrice() - this.amount;
          p.setPrice(price);
          break;
        }
      }
    }

  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Cateogry getCateogryType() {
    return cateogryType;
  }

  public void setCateogryType(Cateogry cateogryType) {
    this.cateogryType = cateogryType;
  }

  public int getCountOfItem() {
    return countOfItem;
  }

  public void setCountOfItem(int countOfItem) {
    this.countOfItem = countOfItem;
  }

}
