package lowleveldesign.bookmyshow.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lowleveldesign.bookmyshow.api.core.entities.base.BaseAbstractAuditableEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie extends BaseAbstractAuditableEntity {

    @NotBlank
    @Column(name = "movie_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "cbfc_rating")
    private CBFCRating cbfcRating;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    @Lob
    private String summary;

    @ManyToMany
    @JoinTable(name = "movies__genres__mapping",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<MovieShow> movieShows;

    @ManyToMany
    @JoinTable(name = "movies__coupons__mapping",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "coupon_id"))
    private Set<Coupon> coupons;

}
