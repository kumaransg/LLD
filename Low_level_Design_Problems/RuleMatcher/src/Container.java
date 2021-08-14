import java.util.List;

public class Container {
    private String id;

    public List<Container> getChildContainers() {
        return childContainers;
    }

    public void setChildContainers(List<Container> childContainers) {
        this.childContainers = childContainers;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    private List<Container> childContainers;
    private List<Item> items;

}