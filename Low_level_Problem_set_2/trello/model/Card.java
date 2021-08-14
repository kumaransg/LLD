package trello.model;

/**
 * @author priyamvora
 * @created 20/04/2021
 */
public class Card extends Entity {
    private String description;
    private String assignedTo;

    public Card(String name) {
        super(name);
    }

    public Card(String name, String assignedTo) {
        super(name);
        this.assignedTo = assignedTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return super.toString() + " Card{" +
                "description='" + description + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                '}';
    }
}
