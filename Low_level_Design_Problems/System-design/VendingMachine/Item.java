package Nav;

/**
 * Items or products supported by Vending Machine.
 * @author Abhimanyu Sharma
 */

public enum Item {
	
	COKE("Coke",100), PEPSI("pepsi",50), LAYS("Lays",75);
	
	private String  name;
	private int price;
	
	private Item(String name,int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}
