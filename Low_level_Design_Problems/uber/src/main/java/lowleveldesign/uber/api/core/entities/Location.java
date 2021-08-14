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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "locations", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "latitude", "longitude"
        })
})
public class Location extends BaseAbstractAuditableEntity {

    @NaturalId
    @NotBlank
    @Column(nullable = false)
    private String latitude;

    @NaturalId
    @NotBlank
    @Column(nullable = false)
    private String longitude;

    private String streetAddress;
    private String street;
    private String area;
    private String policeStation;
    private String city;
    private String district;
    private String state;
    private String country;
    private String pinCode;

}