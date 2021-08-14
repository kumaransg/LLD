package SystemDesign.ParkingLot;

import SystemDesign.ParkingLot.Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingMain {
    public static void main(String[] args) throws InterruptedException {
        String nameOfParkingLot ="Pintosss Parking Lot";
        Address address = Address.builder().city("Bangalore").country("India").state("KA").build();
        Map<ParkingSlotType, Map<String,ParkingSlot>>  allSlots = new HashMap<>();
        Map<String,ParkingSlot> compactSlot = new HashMap<>();
        compactSlot.put("C1",new ParkingSlot("C1",ParkingSlotType.Compact));
        compactSlot.put("C2",new ParkingSlot("C2",ParkingSlotType.Compact));
        compactSlot.put("C3",new ParkingSlot("C3",ParkingSlotType.Compact));
        allSlots.put(ParkingSlotType.Compact,compactSlot);

        Map<String,ParkingSlot> largeSlot = new HashMap<>();
        largeSlot.put("L1",new ParkingSlot("L1",ParkingSlotType.Large));
        largeSlot.put("L2",new ParkingSlot("L2",ParkingSlotType.Large));
        largeSlot.put("L3",new ParkingSlot("L3",ParkingSlotType.Large));
        allSlots.put(ParkingSlotType.Large,largeSlot);
        ParkingFloor parkingFloor = new ParkingFloor("1",allSlots);
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        parkingFloors.add(parkingFloor);
        ParkingLot parkingLot = ParkingLot.getInstance(nameOfParkingLot,address,parkingFloors);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleCategory(VehicleCategory.Hatchback);
        vehicle.setVehicleNumber("KA-01-MA-9999");

        Ticket ticket = parkingLot.assignTicket(vehicle);
        System.out.println(" ticket number >> "+ticket.getTicketNumber());
        //persist the ticket to db here
        Thread.sleep(10000);
        double price = parkingLot.scanAndPay(ticket);
        System.out.println("price is >>" + price);
    }
}
