public class FoodService extends ExtraChargeDecorator{
    public FoodService(IBaseRoom room) {
        super(room);
    }
    public int getCost() {
        System.out.println("Food-service-"+150);
        return room.getCost()+150;
    }
}
