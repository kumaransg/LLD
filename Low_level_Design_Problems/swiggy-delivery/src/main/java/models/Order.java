package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class Order {

    private String id;

    @JsonProperty("restaurant_location")
    private Location restaurantLocation;

    @JsonProperty("ordered_time")
    private Long orderedTime;

    public Double getPriority() {
//        if()
        return (double) (System.currentTimeMillis() - orderedTime); // in case of entension based on area you could write it here
    }
}
