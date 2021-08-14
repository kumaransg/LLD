package restaurant;

import enums.ItemStatus;
import enums.MenuType;
import enums.MenuType;

public class FoodItem {
    private String name;
    private ItemStatus status;
    private MenuType category;
    private Double price;

    public FoodItem(String itemName, MenuType category, Double price){
        this.name = itemName;
        this.category = category;
        this.status = ItemStatus.AVAILABLE;
        this.price = price;
    }

    public FoodItem(String itemName, MenuType category, Double price,ItemStatus foodStatus){
        this.name = itemName;
        this.category = category;
        this.status = foodStatus;
        this.price = price;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the status
     */
    public ItemStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    /**
     * @return the category
     */
    public MenuType getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(MenuType category) {
        this.category = category;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}
