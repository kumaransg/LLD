package SystemDesign.ParkingLot2;

public class ParkingDisplayBoard {
    String id;
    private HandicappedSpot HandicappedFreeSpot;
    private LargeSpot LargeFreeSpot;
    private CompactSpot CompactFreeSpot;
    private MotorBikeSpot MotorbikeFreeSpot;
    private ElectricSpot ElectricFreeSpot;

    public void ShowSpotNumber(){
        if(HandicappedFreeSpot.available){
            System.out.println("Handicapped Spot Free :" +HandicappedFreeSpot.number);
        }
        else{
            System.out.println("Handicapped spots not free");
        }

        if(LargeFreeSpot.available){
            System.out.println("LargeFreeSpot Spot Free :" +LargeFreeSpot.number);
        }
        else{
            System.out.println("LargeFreeSpot spots not free");
        }
        if(CompactFreeSpot.available){
            System.out.println("CompactFreeSpot Spot Free :" +CompactFreeSpot.number);
        }
        else{
            System.out.println("CompactFreeSpot spots not free");
        }
        if(MotorbikeFreeSpot.available){
            System.out.println("MotorbikeFreeSpot Spot Free :" +MotorbikeFreeSpot.number);
        }
        else{
            System.out.println("MotorbikeFreeSpot spots not free");
        }
        if(ElectricFreeSpot.available){
            System.out.println("ElectricFreeSpot Spot Free :" +ElectricFreeSpot.number);
        }
        else{
            System.out.println("ElectricFreeSpot spots not free");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HandicappedSpot getHandicappedFreeSpot() {
        return HandicappedFreeSpot;
    }

    public void setHandicappedFreeSpot(HandicappedSpot handicappedFreeSpot) {
        HandicappedFreeSpot = handicappedFreeSpot;
    }

    public LargeSpot getLargeFreeSpot() {
        return LargeFreeSpot;
    }

    public void setLargeFreeSpot(LargeSpot largeFreeSpot) {
        LargeFreeSpot = largeFreeSpot;
    }

    public CompactSpot getCompactFreeSpot() {
        return CompactFreeSpot;
    }

    public void setCompactFreeSpot(CompactSpot compactFreeSpot) {
        CompactFreeSpot = compactFreeSpot;
    }

    public MotorBikeSpot getMotorbikeFreeSpot() {
        return MotorbikeFreeSpot;
    }

    public void setMotorbikeFreeSpot(MotorBikeSpot motorbikeFreeSpot) {
        MotorbikeFreeSpot = motorbikeFreeSpot;
    }

    public ElectricSpot getElectricFreeSpot() {
        return ElectricFreeSpot;
    }

    public void setElectricFreeSpot(ElectricSpot electricFreeSpot) {
        ElectricFreeSpot = electricFreeSpot;
    }
}
