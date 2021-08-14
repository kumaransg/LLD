package HotelManagmentSystem;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    Map<String, User> customerDatabase = new HashMap<>();

    Map<String, Employee> employeeDatabase = new HashMap<>();

    public UserStatus validateUserDetails(String userId){
        return UserStatus.NEW_USER;
    }
}
