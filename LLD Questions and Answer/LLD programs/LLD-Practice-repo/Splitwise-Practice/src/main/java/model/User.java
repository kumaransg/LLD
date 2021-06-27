package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class User {
    private int userId;
    private String name;
    private String email;
    private int mobNumber;
    private Map<User,Float> friends;

    public User(int userId, String name, String email, int mobNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobNumber = mobNumber;
    }

    public void addFriend(User user){
        friends.put(user,Float.valueOf(0));
    }

    public void addExpenseForFriend(User user, Float expense){
        if(friends.containsKey(user)){
            Float prevExpense= friends.get(user);
            friends.put(user, prevExpense+ expense);
        }else{
            friends.put(user, expense);
        }
    }


}
