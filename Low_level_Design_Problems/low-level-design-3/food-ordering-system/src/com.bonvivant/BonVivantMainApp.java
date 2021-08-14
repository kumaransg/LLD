import java.util.HashMap;
import java.util.Random;
import enums.MenuType;
import restaurant.Menu;
import restaurant.Restaurant;
import restaurant.FoodItem;
import system.BonVivantRestaurantDriver;
import system.RestaurantManager;

public class BonVivantMainApp {
    public static void main(String [] args){
        System.out.println("Initializing Food Ordering System...");
        /**
         * Initiating restaurant driver
         */
        BonVivantRestaurantDriver bonVivantRestaurantDriver = BonVivantRestaurantDriver.getInstance();

        RestaurantManager restaurantManager = bonVivantRestaurantDriver.getRestaurantManager();

        try {
            Menu r1Menu = new Menu();
            r1Menu.addFoodItem(new FoodItem("BigFry", MenuType.VEG, 100.0));
            r1Menu.addFoodItem(new FoodItem("BigFish", MenuType.NONVEG, 200.0));
            r1Menu.addFoodItem(new FoodItem("BigFryFish", MenuType.NONVEG, 400.0));

            Restaurant restaurant1 = new Restaurant("HelloFoodie", getRandomCapacity(), r1Menu);

            restaurantManager.addRestaunrant(restaurant1);

            Restaurant restaurant2 = new Restaurant.Builder("FoodieFoody").setCapacity(getRandomCapacity()).build();
            Menu r2Menu = new Menu();
            r2Menu.addFoodItem(new FoodItem("BigFry", MenuType.VEG, 100.0));
            r2Menu.addFoodItem(new FoodItem("BigFish", MenuType.NONVEG, 200.0));
            restaurant2.setMenu(r2Menu);
            restaurantManager.addRestaunrant(restaurant2);

            Restaurant restaurant3 = new Restaurant.Builder("I_AM_HUNGRY").setCapacity(getRandomCapacity()).build();
            Menu r3Menu = new Menu();
            r3Menu.addFoodItem(new FoodItem("BigFry", MenuType.VEG, 100.0));
            r3Menu.addFoodItem(new FoodItem("BigFish", MenuType.NONVEG, 200.0));
            r3Menu.addFoodItem(new FoodItem("BigFryFish", MenuType.NONVEG, 300.0));
            restaurant3.setMenu(r3Menu);
            restaurantManager.addRestaunrant(restaurant3);

            System.out.println(restaurantManager.findRestaurant("HelloFoodie"));
            // Find restaurant by order items

            HashMap<String, Integer> orderItems = new HashMap<>();
            orderItems.put("BigFish", 2);
            orderItems.put("BigFryFish", 2);

            System.out.println(restaurantManager.findBy(orderItems).getName());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    static Integer getRandomCapacity() {
        Integer MAX_CAPACITY = 10;
        return (new Random().nextInt(MAX_CAPACITY) + 1);
    }
}
