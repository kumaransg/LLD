package Nav;

import java.util.*;

public class MainService {
	public static void main(String args[]) {
		
		vendingMachineImpl vmImpl = new vendingMachineImpl();
		List<User> user = new LinkedList<User>();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String name;
		int id;
		
		System.out.print("Enter How many users you want to register : ");
		int numberofUsers = scanner.nextInt();
		
		for(int i=0;i<numberofUsers;i++) {
			System.out.println("Enter your name and id : ");
			name = scanner.next();
			id   = scanner.nextInt();
			user.add(new User(name,id,0));
		}
		
		vmImpl.addUsers(user);
		vmImpl.initAmount(user);
		for(User u : user) {
			vmImpl.insertAmount(u, Amount.FIVEHUNDRED);
		}
		
		System.out.print("Enter your name and user id : ");
		name = scanner.next();
		id   = scanner.nextInt();
		vmImpl.transaction(user.get(id), Item.LAYS);
		vmImpl.getCashInventory();
	}
}
