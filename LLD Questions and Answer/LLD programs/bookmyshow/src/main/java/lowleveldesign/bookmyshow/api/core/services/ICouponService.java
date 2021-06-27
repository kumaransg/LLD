package lowleveldesign.bookmyshow.api.core.services;

import lowleveldesign.bookmyshow.api.core.entities.Booking;
import lowleveldesign.bookmyshow.api.core.entities.Coupon;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ICouponService {

    Set<Coupon> getCouponsSortedByDiscountDescending(Booking booking);

}
