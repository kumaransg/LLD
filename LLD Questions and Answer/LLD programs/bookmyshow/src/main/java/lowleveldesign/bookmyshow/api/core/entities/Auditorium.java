package lowleveldesign.bookmyshow.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lowleveldesign.bookmyshow.api.core.entities.base.BaseAbstractAuditableEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auditoriums")
public class Auditorium extends BaseAbstractAuditableEntity {

    private String hallName;
    private Integer screenHeight;
    private Integer screenLength;

    @ManyToMany
    @JoinTable(name = "auditorium__auditorium_feature__mapping",
            joinColumns = @JoinColumn(name = "auditorium_id"),
            inverseJoinColumns = @JoinColumn(name = "auditorium_feature_id"))
    private Set<AuditoriumFeature> features;

    @OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
    private Set<Seat> seats;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    @OneToMany(mappedBy = "auditorium"/*, cascade = CascadeType.ALL*/)
    private Set<MovieShow> movieShows;

}
