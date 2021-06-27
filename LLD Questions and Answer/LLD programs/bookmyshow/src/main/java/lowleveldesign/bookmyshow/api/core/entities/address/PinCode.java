package lowleveldesign.bookmyshow.api.core.entities.address;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pin_codes")
public class PinCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NaturalId
    @Column(name = "pin_code", nullable = false, unique = true)
    private Integer pinCode;

    @ManyToOne
    @JoinColumn(name = "taluk_id")
    private Taluk taluk;

    @ManyToOne
    @JoinColumn(name = "sub_district_id")
    private SubDistrict subDistrict;

}
