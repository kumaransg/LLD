package lowleveldesign.bookmyshow.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cbfc_ratings")
@org.hibernate.annotations.Table(appliesTo = "cbfc_ratings", comment = "Central Board of Film Certification ratings")
public class CBFCRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String certificationId;

    private String summary;

}


/*
    U: Unrestricted public exhibition (Suitable for all age groups)
    U/A: Parental guidance for children under age 12
    A: Restricted to adults(Nobody allowed under the age of 18.)
    S: Restricted to a specialised groups of people, such as engineers, doctors or scientists[6]

    Sometimes alternate film certificates issued are V/U, V/UA, V/A which are similar to U, U/A, A
 */
