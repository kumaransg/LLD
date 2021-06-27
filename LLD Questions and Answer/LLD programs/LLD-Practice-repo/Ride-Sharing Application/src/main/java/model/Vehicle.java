package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Vehicle {
    private String name;
    private String vehicleNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getName(), vehicle.getName()) &&
                Objects.equals(getVehicleNumber(), vehicle.getVehicleNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getVehicleNumber());
    }
}
