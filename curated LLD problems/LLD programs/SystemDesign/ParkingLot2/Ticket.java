package SystemDesign.ParkingLot2;

import java.util.Date;

public class Ticket {
    String id;

    public Ticket() {
        this.id = new Date().toString();
    }

    public String getNumber() {
        return id;
    }
}
