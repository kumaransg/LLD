package lowleveldesign.bookmyshow.api.core.services;

import lowleveldesign.bookmyshow.api.core.entities.Booking;
import lowleveldesign.bookmyshow.api.core.entities.ShowSeat;
import lowleveldesign.bookmyshow.api.core.entities.User;

public interface IBookingService {

    Booking book(ShowSeat showSeat, User user);

}
