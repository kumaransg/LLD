package stackoverflow.model;

import stackoverflow.constants.VoteType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public abstract class Entity {
    private final String entityId;
    private String content;
    private Map<VoteType, Integer> voteTypeCountMap;
    private Member owner;

    public Entity(String content, Member owner) {
        this.entityId = UUID.randomUUID().toString();
        this.content = content;
        this.voteTypeCountMap = new HashMap<>();
        this.owner = owner;
    }

    public String getEntityId() {
        return entityId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Map<VoteType, Integer> getVoteTypeCountMap() {
        return voteTypeCountMap;
    }

    public void setVoteTypeCountMap(Map<VoteType, Integer> voteTypeCountMap) {
        this.voteTypeCountMap = voteTypeCountMap;
    }

    public Member getOwner() {
        return owner;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "entityId='" + entityId + '\'' +
                ", content='" + content + '\'' +
                ", voteTypeCountMap=" + voteTypeCountMap +
                ", owner=" + owner +
                '}';
    }
}
