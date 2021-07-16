package io.abhi.cartdesign;

public class Item extends Product {

   private Cateogry cateogryName;

  public Item(int id, String name, final Cateogry cateogry, double price) {
    super(id, name, price);
    this.cateogryName = cateogry;
   // this.price = price;
  }

  @Override
  public boolean isCoupon() {
    return false;
  }

  public Cateogry getCateogryName() {
    return cateogryName;
  }

  public void setCateogryName(Cateogry cateogryName) {
    this.cateogryName = cateogryName;
  }
}
