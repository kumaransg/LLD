package trello.model;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 20/04/2021
 */
public abstract class Entity {
    private final String entityId;
    private String name;

    public Entity(String name) {
        this.entityId = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "entityId='" + entityId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
