package lowleveldesign.uber.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lowleveldesign.uber.api.core.entities.base.BaseAbstractAuditableEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "riders")
public class Rider extends BaseAbstractAuditableEntity {

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "home_location_id", referencedColumnName = "id", nullable = false)
    private Location homeLocation;

    @OneToOne
    @JoinColumn(name = "work_location_id", referencedColumnName = "id", nullable = false)
    private Location workLocation;

    @OneToOne
    @JoinColumn(name = "preferred_payment_method_id", referencedColumnName = "id", nullable = false)
    private PaymentMethod preferredPaymentMethod;

    @OneToMany(mappedBy = "rider")
    private List<PaymentMethod> paymentMethods;

}
