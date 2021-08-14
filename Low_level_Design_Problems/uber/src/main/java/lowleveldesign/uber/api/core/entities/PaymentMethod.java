package lowleveldesign.uber.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lowleveldesign.uber.api.core.entities.base.BaseAbstractAuditableEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_methods")
public class PaymentMethod extends BaseAbstractAuditableEntity {

    @OneToOne
    @JoinColumn(name = "payment_method_type_id", nullable = false)
    private PaymentMethodType paymentMethodType;

    private Double maxAdvanceAmountMonthly;
    private Double utilizedAdvance;

    private String cardNumber;

    @OneToOne
    @JoinColumn(name = "card_type_id", referencedColumnName = "id")
    private CardType cardType;

    @ManyToOne
    @JoinColumn(name = "payment_gateway_id", referencedColumnName = "id", nullable = false)
    private PaymentGateway paymentGateway; // cash by default

    @ManyToOne
    @JoinColumn(name = "rider_id", referencedColumnName = "id", nullable = false)
    private Rider rider;

}
