package lowleveldesign.bookmyshow.api.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lowleveldesign.bookmyshow.api.core.entities.base.BaseAbstractAuditableEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseAbstractAuditableEntity {

    @NotBlank
    @Size(max = 40)
    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @NotBlank
    @Size(max = 16)
    @Column(name = "user_name", unique = true, nullable = false, length = 16)
    private String username;

    @NotBlank
    @Size(max = 100)
    private String password;

    @NotBlank
    @Size(max = 40)
    @Email
    @Column(name = "email_id")
    private String email;

    @NaturalId
    @NotBlank
    @Size(max = 10)
    @Column(name = "mobile_number", unique = true, nullable = false, length = 10)
    private String mobileNumber;

    @NotBlank
    @OneToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToMany
    @JoinTable(name = "users__coupons__mapping",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "coupons_id"))
    private Set<Coupon> coupons;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users__roles__mapping",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void resetPassword(String newPassword) {
        this.setPassword(newPassword);
    }

}
