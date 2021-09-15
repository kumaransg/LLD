package model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class User {
    private String name;
    private String gender;
    private int age;
    Map<Vehicle, String> vechicles;

    public User(String name, String gender, Integer age){
        this.name= name;
        this.age= age;
        this.gender= gender;
        vechicles= new HashMap<Vehicle, String>();
    }

    public void addVechicle(Vehicle vehicle){
        vechicles.put(vehicle, vehicle.getVehicleNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(vechicles, user.vechicles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, vechicles);
    }
}
