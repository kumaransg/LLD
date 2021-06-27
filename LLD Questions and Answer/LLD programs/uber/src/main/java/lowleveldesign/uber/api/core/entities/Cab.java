package lowleveldesign.uber.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lowleveldesign.uber.api.core.entities.base.BaseAbstractAuditableEntity;

import javax.persistence.Column;
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
@Table(name = "cabs")
public class Cab extends BaseAbstractAuditableEntity {

    @Column(unique = true, nullable = false)
    private String vehicleRegistrationNumber;

    @Column(length = 40)
    private String brand;

    @Column(length = 40)
    private String model;

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "cab_type_id", referencedColumnName = "id")
    private CabType cabType;

    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    private Color color;

    @Builder.Default
    @Column(name = "air_conditioned")
    private boolean isAirConditioned = false;

    @Builder.Default
    private int capacity = 1;

}
