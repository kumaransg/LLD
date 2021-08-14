package online_book_reader_system;

import java.util.HashMap;

/* 
* This class represents the UserManager which is responsible  
* for managing the users, their membership etc. 
*/

public class UserManager {
	private HashMap<Integer, User> users; 
	  
    public UserManager() { 
        users = new HashMap<Integer, User>(); 
    } 
    public Boolean addUser(int id, String details, String name) { 
        if (users.containsKey(id)) { 
            return false; 
        } 
        User user = new User(id, details, name); 
        users.put(id, user); 
        return true; 
    } 
  
    public Boolean addUser(User user) { 
        if (users.containsKey(user.getID())) { 
            return false; 
        } 
  
        users.put(user.getID(), user); 
        return true; 
    } 
  
    public boolean remove(User u) { 
        return remove(u.getID()); 
    } 
  
    public boolean remove(int id) {
        if (users.containsKey(id)) { 
            return false; 
        } 
        users.remove(id); 
        return true; 
    } 
  
    public User find(int id) { 
        return users.get(id); 
    } 
}
