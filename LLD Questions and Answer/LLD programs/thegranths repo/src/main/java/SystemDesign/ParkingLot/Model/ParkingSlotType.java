package SystemDesign.ParkingLot.Model;

public enum ParkingSlotType {
    TwoWheeler{
        public double getPriceForParking(long duration){
            return duration*0.05;
        }
    },
    Compact{
        public double getPriceForParking(long duration){
            return duration*0.075;
        }
    },
    Medium{
        public double getPriceForParking(long duration){
            return duration*0.09;
        }
    },
    Large{
        public double getPriceForParking(long duration){
            return duration*0.10;
        }
    };

   public abstract double getPriceForParking(long duration);
}
