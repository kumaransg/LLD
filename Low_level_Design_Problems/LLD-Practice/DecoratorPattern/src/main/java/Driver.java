public class Driver {
    public static void main(String[] args) {
        IBaseRoom newRoom= new FoodService(new WineService(new DeluxeRoom()));
        System.out.println(newRoom.getCost());
    }
}
