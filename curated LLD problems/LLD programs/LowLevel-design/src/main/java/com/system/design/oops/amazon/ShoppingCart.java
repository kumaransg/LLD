package com.system.design.oops.amazon;

import java.util.Collections;
import java.util.List;

public class ShoppingCart {
    private List<Items> items;

    public boolean addItem(Item item){ return true;}
    public boolean removeItem(Item item){ return true;}
    public boolean updateItemQuantity(Item item, int quantity){ return true;}
    public List<Item> getItems(){ return Collections.EMPTY_LIST;}
    public boolean checkout(){ return true;}
}
