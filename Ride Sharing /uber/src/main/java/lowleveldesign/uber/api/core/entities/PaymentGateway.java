package lowleveldesign.uber.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lowleveldesign.uber.api.core.entities.base.BaseAbstractAuditableEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_gateways")
public class PaymentGateway extends BaseAbstractAuditableEntity {

    @NaturalId
    @NotBlank
    @Size(max = 20)
    @Column(unique = true, nullable = false, length = 20)
    private String name;

}
