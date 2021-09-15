package lowleveldesign.uber.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lowleveldesign.uber.api.core.entities.base.BaseAbstractAuditableEntity;
import lowleveldesign.uber.api.utils.RandomUtils;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "otps")
public class OTP extends BaseAbstractAuditableEntity {

    @NotBlank
    @Column(nullable = false)
    private String code;

    @NotBlank
    @Column(nullable = false)
    private String sentToNumber;

    @Builder.Default
    private Integer attemptsMade = 0;

    @Builder.Default
    private Boolean isExpired = false;

    public OTP randomGenerator(final String sentToNumber) {
        return OTP.builder()
                .code(RandomUtils.getRandom6Length())
                .sentToNumber(sentToNumber)
                .build();
    }

}
