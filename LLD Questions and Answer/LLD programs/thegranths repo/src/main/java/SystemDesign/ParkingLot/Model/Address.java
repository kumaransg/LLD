package SystemDesign.ParkingLot.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {
    String street;
    String block;
    String city;
    String state;
    String country;
}
