package parkingLot2.model;

import parkingLot2.constants.TicketStatus;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 12/05/2021
 */
public class ParkingTicket {
    private final String ticketId;
    private Vehicle vehicle;
    private final String parkingFloorId;
    private final String parkingSpotId;
    private Long entryTime;
    private Long exitTime;
    private Double charges;
    private TicketStatus ticketStatus;

    public ParkingTicket(Vehicle vehicle, Long entryTime, String parkingFloorId, String parkingSpotId) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.ticketStatus = TicketStatus.ACTIVE;
        this.parkingFloorId = parkingFloorId;
        this.parkingSpotId = parkingSpotId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Long entryTime) {
        this.entryTime = entryTime;
    }

    public Long getExitTime() {
        return exitTime;
    }

    public void setExitTime(Long exitTime) {
        this.exitTime = exitTime;
    }

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }


    public void unparkVehicle() {
        this.exitTime = System.currentTimeMillis() / 1000;
        this.charges = (exitTime - entryTime) * 10.0;
        this.ticketStatus = TicketStatus.PAID;
    }

    public static ParkingTicket buildParkingTicket(Vehicle vehicle, String parkingFloorId, String parkingSpotId) {
        ParkingTicket parkingTicket = new ParkingTicket(vehicle, System.currentTimeMillis() / 1000, parkingFloorId, parkingSpotId);
        return parkingTicket;
    }

    public String getParkingFloorId() {
        return parkingFloorId;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicle=" + vehicle +
                ", parkingFloorId='" + parkingFloorId + '\'' +
                ", parkingSpotId='" + parkingSpotId + '\'' +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", charges=" + charges +
                ", ticketStatus=" + ticketStatus +
                '}';
    }
}
