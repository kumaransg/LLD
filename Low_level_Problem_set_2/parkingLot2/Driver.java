package parkingLot2;

import parkingLot2.constants.VehicleType;
import parkingLot2.dao.ParkingLotDao;
import parkingLot2.model.ParkingTicket;
import parkingLot2.model.Vehicle;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 12/05/2021
 */
public class Driver {
    public static void main(String[] args) {
//        ParkingLotDao parkingLotDao = new ParkingLotDao("P1");
//        parkingLotDao.addParkingFloor("1");
//        parkingLotDao.addParkingSpot("1", "1", VehicleType.BIKE);
//        parkingLotDao.addParkingSpot("1", "2", VehicleType.BIKE);
//        parkingLotDao.addParkingSpot("1", "3", VehicleType.CAR);
//        parkingLotDao.addParkingSpot("1", "4", VehicleType.CAR);
//        parkingLotDao.addParkingFloor("2");
//        parkingLotDao.addParkingSpot("2", "1", VehicleType.TRUCK);
//        parkingLotDao.addParkingSpot("2", "2", VehicleType.TRUCK);
//        parkingLotDao.debug();
//
//        Vehicle vehicle = new Vehicle("GJ 11 S 3604", "silver", VehicleType.TRUCK);
//        ParkingTicket parkingTicket = parkingLotDao.assignSpotToVehicle(vehicle);
//        System.out.println(parkingTicket);
//        System.out.println(parkingLotDao.unparkVehicle(parkingTicket));

       System.out.println(UUID.fromString("b19b59b2-ae89-4005-a9a9-29c0bb62cfde").timestamp());

    }
}
