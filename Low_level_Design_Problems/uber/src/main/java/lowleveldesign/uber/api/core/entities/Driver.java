package lowleveldesign.uber.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lowleveldesign.uber.api.core.entities.base.BaseAbstractAuditableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drivers")
public class Driver extends BaseAbstractAuditableEntity {

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(nullable = false, unique = true)
    private String drivingLicenseNumber;

    private Integer age;

    @OneToOne
    @JoinColumn(name = "cab_id", referencedColumnName = "id")
    private Cab cab;

    @Builder.Default
    @Column(name = "availability_status")
    private boolean isAvailable = true;

    public void markUnavailable() {
        this.isAvailable = false;
    }

}
