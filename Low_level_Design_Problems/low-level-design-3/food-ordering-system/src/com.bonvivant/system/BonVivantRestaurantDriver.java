package system;

/**
 * BonVivantRestaurantDriver is just a wrapper class for RestaurantManager
 * Can  be removed this if not needed in future
 */

public class BonVivantRestaurantDriver {
    private RestaurantManager restaurantManager = null;

    private static BonVivantRestaurantDriver instance = null;
    
    private BonVivantRestaurantDriver(){
        restaurantManager = RestaurantManager.getInstance();
    }

    public static BonVivantRestaurantDriver getInstance(){
        if(instance == null){
            instance = new BonVivantRestaurantDriver();
        }
        return instance;
    }

    /**
     * @return the restaurantManager
     */
    
    public RestaurantManager getRestaurantManager() {
        return restaurantManager;
    }
}
