
package SystemDesign.ParkingLot;

//implemented by having just a variable which represents the size of the spot
public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int lane;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level lvl, int r, int n, VehicleSize s) {
        level = lvl;
        lane = r;
        spotNumber = n;
        spotSize = s;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        //check if the spot is big enough and is available
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    public boolean park(Vehicle v) {
        if (!canFitVehicle(v))
            return false;

        vehicle = v;
        vehicle.parkInSpot(this);
        return true;
    }

    public int getLane() {
        return lane;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleSize getSize() {
        return spotSize;
    }

    public void removeVehicle() {
        level.spotFreed();
        vehicle = null;
    }
}