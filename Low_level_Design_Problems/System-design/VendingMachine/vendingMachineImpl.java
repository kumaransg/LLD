package Nav;

/**
 * Sample implementation of Vending Machine in Java
 * @author Abhimanyu Sharma
 */

import java.util.*;
public class vendingMachineImpl implements vendingMachine {
	
	List<User> userList;
	HashMap<User, Long> cashInventory;
	HashMap<Item,Integer> itemInventory;
	User user;
	Item currentItem;
	long selectedItemPrice;
	long userbalance;
	
	public vendingMachineImpl() {
		intialize();
	}
	
	private void intialize() {
		cashInventory = new HashMap<User,Long>();
		userList = new LinkedList<User>();
		itemInventory = new HashMap<Item,Integer>();
		
		for(Item it : Item.values()) {
			itemInventory.put(it, 5);
		}
	}

	@Override
	public void addUsers(List<User> uL) {
		
		for(User u : uL) {
			userList.add(u);
		}
	}
	
	@Override
	public void initAmount(List<User> uList) {
		
		for(User u : uList) {
			cashInventory.put(u, (long) 0);
		}
	}
	
	@Override
	public void insertAmount(User user, Amount amount) {
		if(cashInventory.get(user) != null) {
			long currentBalance = user.getBalance();
			currentBalance = currentBalance + amount.getDenomination();
			cashInventory.put(user, currentBalance);
		} else {
			System.out.println("No such user exists, please sign up");
			// TO-DO
			
		}
	}
	
	@Override
	public long selectItemandGetPrice(User user, Item item) {
		System.out.println("User: "+ user.getName()+" selects item : " + item.getName());
		if(itemInventory.containsKey(item)) {
			currentItem = item;
			System.out.println("Item : "+currentItem.getName() +" is present and its price is : " +currentItem.getPrice());
			return currentItem.getPrice(); 
		} else {
			System.out.println("No such item exists");
		}
		return 0;
	}
	
	public void transaction(User user, Item item) {
		if(user != null) {
			selectedItemPrice = selectItemandGetPrice(user,item);
			if(selectedItemPrice != 0) {
				userbalance = cashInventory.get(user);
				System.out.println("User :" + user.getName()+" has balance : " + userbalance);
				System.out.println("Selected item has price : " + selectedItemPrice);
				if(selectedItemPrice <= userbalance) {
					long remainingbalance = userbalance - selectedItemPrice;
					cashInventory.put(user,remainingbalance);
				} else {
					System.out.println("Insufficient funds");
				}
			} else {
				System.out.println("No such item exists");
			}
		} else {
			System.out.println("No such user exists, please sign up");
		}
	}
 	@Override
	public void reset() {
 		cashInventory.clear();
        itemInventory.clear();
	}
 	
 	// For priting and checking stats
 	
 	public void printStats(){
        System.out.println("Current Item Inventory : " + itemInventory);
        System.out.println("Current Cash Inventory : " + cashInventory);
    }
 	
	public void getUsersList() {
		for(User u : userList) {
			System.out.println("User : "+u.getName() + "\n has balance:	"+u.getBalance() + "\n and has ID :	"+u.getID());
		}
	}
	
	public void getCashInventory() {
		for (Map.Entry<User,Long> entry : cashInventory.entrySet())
            System.out.println("Name = " + entry.getKey().getName() +
                             ", Balance = " + entry.getValue());
	}
}
