package SystemDesign.ParkingLot;

public class Main {

    public static void main(String[] args) {


        ParkingLot P1 = new ParkingLot(2);

       Car c1 = new Car("1234","Microsoft");
       Motorcycle c2 = new Motorcycle("4556","Microsoft");
       Car c3 = new Car("1680","ServiceNow");
       Motorcycle c4 = new Motorcycle("0789","ServiceNow");
       Car c5 = new Car("1789","Microsoft");
       P1.parkVehicle(c1);
       P1.parkVehicle(c2);
       P1.parkVehicle(c3);
       P1.ComapnyParked("Microsoft");
       P1.ComapnyParked("ServiceNow");
       P1.leave(c2,0);
       //Note that c2 is from Microsoft
       P1.ComapnyParked("Microsoft");
       P1.parkVehicle(c4);
       P1.parkVehicle(c5);


    }
}
