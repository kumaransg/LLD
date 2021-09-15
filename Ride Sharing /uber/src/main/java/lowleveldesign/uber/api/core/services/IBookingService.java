package lowleveldesign.uber.api.core.services;

import lowleveldesign.uber.api.core.entities.Booking;
import lowleveldesign.uber.api.core.entities.Driver;
import lowleveldesign.uber.api.core.entities.PaymentReceipt;
import lowleveldesign.uber.api.core.entities.Rider;

public interface IBookingService {

    Booking book(Rider rider);
    boolean acceptBooking(Booking booking, Driver driver);
    void cancel(Booking booking);
    PaymentReceipt makePayment(Booking booking);

}
