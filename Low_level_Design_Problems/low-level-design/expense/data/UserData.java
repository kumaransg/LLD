package expense.data;

import expense.models.User;

import java.util.*;

public class UserData {

    private static UserData userData;
    private Map<String, User> userMap;

    private UserData(){
        userMap = new HashMap<>();
    }

    public static UserData getInstance(){
        if(userData == null){
            userData = new UserData();
        }
        return userData;
    }

    public Optional<User> getUser(String userId){
        return Optional.ofNullable(userMap.get(userId));
    }

    public void addUser(User user){
        userMap.put(user.getUserId(), user);
    }

    public List<User> getAllUsers(){
        List<User> allUsers = new ArrayList<>();
        userMap.values().forEach(user -> allUsers.add(user));

        return allUsers;
    }
}
