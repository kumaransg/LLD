package lowleveldesign.bookmyshow.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lowleveldesign.bookmyshow.api.core.entities.base.BaseAbstractAuditableEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking extends BaseAbstractAuditableEntity {

    @OneToMany(mappedBy = "booking")
    private Set<ShowSeat> showSeats;

    @Builder.Default
    private Integer totalPrice = 0;

    @ManyToOne
    @JoinColumn(name = "movie_show", nullable = false)
    private MovieShow movieShow;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "booking_viewer", referencedColumnName = "id", nullable = false)
    private User bookingViewer;

    public int seatCount() {
        return this.showSeats.size();
    }

}
