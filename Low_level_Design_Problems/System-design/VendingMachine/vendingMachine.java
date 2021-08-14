package Nav;

/**
 * Declare public API for Vending Machine
 * @author Abhimanyu Sharma
 */

import java.util.*;
public interface vendingMachine {
	
	public void addUsers(List<User> user);
	public void initAmount(List<User> userList);
	public void insertAmount(User user, Amount amount);
	public long selectItemandGetPrice(User user,Item item);
	public void reset();
	
}
