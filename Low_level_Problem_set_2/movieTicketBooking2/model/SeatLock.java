package movieTicketBooking2.model;

import java.util.Date;

/**
 * @author priyamvora
 * @created 25/05/2021
 */
public class SeatLock {
    private Seat seat;
    private Show show;
    private String lockedBy;
    private Integer timeoutInSeconds;
    private Date lockTime;

    public SeatLock(Seat seat, Show show, String lockedBy, Integer timeoutInSeconds, Date lockTime) {
        this.seat = seat;
        this.show = show;
        this.lockedBy = lockedBy;
        this.timeoutInSeconds = timeoutInSeconds;
        this.lockTime = lockTime;
    }

    public Seat getSeat() {
        return seat;
    }

    public Show getShow() {
        return show;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public Integer getTimeoutInSeconds() {
        return timeoutInSeconds;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public boolean isExpired(){
        return true;
    }
}
