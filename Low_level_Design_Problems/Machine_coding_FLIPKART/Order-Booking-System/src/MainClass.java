import java.util.Scanner;

import com.flipart.exception.CustomException;
import com.flipkart.catalog.Catalog;
import com.flipkart.catalog.Product;
import com.flipkart.orders.Orders;
import com.flipkart.users.Users;

public class MainClass {

	public static void main(String args[]) {
		int option = 0;
		Scanner scan = new Scanner(System.in);
		Orders orders = Orders.getInstance();
		Users users = Users.getInstance();
		Catalog catalog = Catalog.getInstance();
		do {

			System.out.println("** FLIPKART SYSTEM ** ");

			System.out.println("****Menu*****");
			System.out.println("0. Exit");
			System.out.println("1. Add Product");
			System.out.println("2. Remove Product");
			System.out.println("3. Purchase Product");
			System.out.println("4. Return Product ");
			System.out.println("5. GetBestSellingProduct");
			System.out.println("6. BlacklistUser");
			System.out.println("7. Orders List");
			System.out.println("8. Display Inventory");

			System.out.println("Enter your option");
			option = scan.nextInt();

			switch (option) {

			case 0:
				System.out.println("Bye Bye");
				return;
			case 1:
				System.out.print("Enter ProductName");
				String productName = scan.next();
				System.out.print("Enter CategoryName");
				String categoryName = scan.next();
				System.out.println("Enter Stock");
				Integer stock = scan.nextInt();
				try {
					Catalog.addProduct(productName, categoryName, stock);
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter ProductName");
				productName = scan.next();
				try {
					Catalog.removeProduct(productName);
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 3:
				System.out.println("Enter Email");
				String email = scan.next();

				System.out.println("Enter ProductName");
				productName = scan.next();

				try {
					orders.purchase(email, productName);
					System.out.println("Product purchased");
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 4:
				System.out.println("Enter Email");
				email = scan.next();

				System.out.println("Enter ProductName");
				productName = scan.next();

				try {
					orders.returnProduct(email, productName);
					System.out.println("Product returned");
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 5:
				System.out.println("Enter CatgeoryName");
				categoryName = scan.next();
				try {
					Product product = orders.getBestSellingProductByCategoryName(categoryName);
					System.out.println("Product Name: " + product.getProductCode());
				} catch (CustomException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;

			case 6:
				System.out.println("Enter Email");
				email = scan.next();
				users.blacklistUser(email);
				System.out.println("Userblacklisted");
				break;
			case 7:
				orders.displayAllOrders();
				break;
			case 8: 
				catalog.displayInventory();
				break;
			default:
				System.out.println("Wrong choice entered");

			}

		} while (option != 0);

		scan.close();

	}
}
