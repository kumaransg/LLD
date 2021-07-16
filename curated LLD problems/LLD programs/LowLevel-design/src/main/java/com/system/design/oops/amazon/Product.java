package com.system.design.oops.amazon;

public class Product {
    private String productID;
    private String name;
    private String description;
    private double price;
    private ProductCategory category;
    private int availableItemCount;

    private Account seller;

    public int getAvailableCount(){ return 1;}
    public boolean updatePrice(double newPrice){ return true;}
}
