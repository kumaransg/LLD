package lowleveldesign.bookmyshow.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lowleveldesign.bookmyshow.api.core.entities.base.BaseAbstractAuditableEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "show_seats")
public class ShowSeat extends BaseAbstractAuditableEntity {

    private Double price;

    @ManyToOne
    @JoinColumn(name = "show_seat_status_id", nullable = false)
    private ShowSeatStatus showSeatStatus;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "movie_show", nullable = false)
    private MovieShow movieShow;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;


}
