package lowleveldesign.uber.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking_status")
public class BookingStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @NotBlank
    @Size(max = 12)
    @Column(unique = true, nullable = false, length = 20)
    private String status; // REQUESTED, ACCEPTED, CANCELED_BY_DRIVER, CANCELLED_BY_RIDER, ARRIVED, RIDE_START, RIDE_END
}
