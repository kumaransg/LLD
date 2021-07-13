import model.Restaurant;
import service.FoodKartRestaurantService;
import service.FoodKartRestaurantServiceImpl;
import service.FoodKartUserService;
import service.FoodKartUserServiceImpl;

import java.util.List;

public class FoodKartApplication {
    public static void main(String[] args) {
        FoodKartUserService userService = new FoodKartUserServiceImpl();
        FoodKartRestaurantService restaurantService = new FoodKartRestaurantServiceImpl();

        userService.registerUser("Pralove", "Male", "phoneNumber-1", "HSR");
        userService.registerUser("Nitesh", "Male", "phoneNumber-2", "BTM");
        userService.registerUser("Vatsal", "female", "phoneNumber-3", "BTM");

        // login user
        userService.loginUser("phoneNumber-1");

        // register restaurant
        restaurantService.registerRestaurant("Food Court-1", "BTM/HSR", "NI Thali", 100, 5);
        restaurantService.registerRestaurant("Food Court-2", "BTM", "Burger", 120, 3);
        restaurantService.registerRestaurant("Food Court-3", "HSR", "SI Thali", 150, 1);

        userService.loginUser("phoneNumber-3");
        List<Restaurant> list = restaurantService.showRestaurant("price");
        for (Restaurant restaurant : list) {
            System.out.println(restaurant.getRestaurantName() + " " + restaurant.getFoodItem().getName());
        }

        if(restaurantService.placeOrder("Food Court-1", 2)){
            System.out.println("Order Placed Successfully");
        }

        if(!restaurantService.placeOrder("Food Court-2", 7)){
            System.out.println("Cannot place order");
        }


        restaurantService.rateRestaurant("Food Court-2", 3, "Good Food");
        restaurantService.rateRestaurant("Food Court-1", 5, "Nice Food");

        list = restaurantService.showRestaurant("rating");
        for (Restaurant restaurant : list) {
            System.out.println(restaurant.getRestaurantName() + " " + restaurant.getFoodItem().getName());
        }

        userService.loginUser("phoneNumber-1");
        restaurantService.updateQuantity("Food Court-2",5);

    }
}
