package lowleveldesign.uber.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lowleveldesign.uber.api.core.entities.base.BaseAbstractAuditableEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking extends BaseAbstractAuditableEntity {


    @ManyToOne
    @JoinColumn(name = "booking_type_id", referencedColumnName = "id", nullable = false)
    private BookingType bookingType;

    @ManyToOne
    @JoinColumn(name = "booking_status_id", referencedColumnName = "id", nullable = false)
    private BookingStatus status;

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "rider_id", referencedColumnName = "id", nullable = false)
    private Rider rider;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ride_start_otp_id", nullable = false)
    private OTP rideStartOTP;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_receipt_id", referencedColumnName = "id")
    private PaymentReceipt paymentReceipt;

    @ManyToMany
    @JoinTable(name = "routes",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private List<Location> route;

}
