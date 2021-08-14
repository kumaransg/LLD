package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Location {
    private Long latitude;
    private Long longitude;

    public Double getDistance(Location otherLocation) {
        return Math.pow(latitude - otherLocation.getLatitude(), 2) + Math.pow(longitude - otherLocation.getLongitude(), 2);
    }
}
