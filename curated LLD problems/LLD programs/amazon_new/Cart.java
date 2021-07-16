package amazon;

import java.util.List;

public class Cart {
    double totalCost;
    List<Item> items;
    
    public double getTotalCost() {return totalCost;}
    public List<Item> getItems(){return items;}
    public void removeItem(Item item) {}
    public void updateItem(Item item) {}
    public void addItem(Item item) {}
}