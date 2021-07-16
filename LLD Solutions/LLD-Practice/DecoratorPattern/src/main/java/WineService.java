public class WineService extends ExtraChargeDecorator {
    public WineService(IBaseRoom room) {
        super(room);
    }

    public int getCost() {
        System.out.println("Wine-service-"+50);
        return room.getCost() + 50;
    }
}
