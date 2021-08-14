package lowleveldesign.facebook.api.core.entities;

import lombok.Builder;
import lombok.Data;
import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.models.handlerdatas.strategyhandlerdata.socialpoints.SocialPointsStrategyHandlerData;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.Address;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.Connection;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.Name;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.Location;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.page.Follower;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.person.Following;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.person.PersonGroup;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.person.PersonLikedPost;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.person.PersonPage;
import lowleveldesign.facebook.api.core.chainofresponsibilities.handlers.utils.ChainOfResponsibilityUtils;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.person.PersonSharedPost;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Builder
@Data
@Table("persons")
public class Person {

    @PrimaryKeyColumn(name = "entity_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID entityId;

    @PrimaryKeyColumn(name = "entity_name", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    @Column("entity_name")
    private String entityName; // equivalent of username

    @Column("person_avatar_url")
    private String avatarUrl;

    @Column("thumbnail_url")
    private String thumbnailUrl;

    @Column("person_name")
    @CassandraType(userTypeName = "name_type", type = CassandraType.Name.UDT)
    private Name name;

    @Column("mobile_number")
    private String mobileNumber;

    @Column("is_person_mobile_number_verified")
    private boolean isMobileNumberVerified;

    @Column("email_id")
    private String email;

    @Column("is_person_email_id_verified")
    private boolean isEmailVerified;

    @Column("gender")
    private String gender;

    @Column("languages")
    private Set<String> languages;

    @Column("native_language")
    private String native_language;

    @Builder.Default
    @Column("language")
    private String language = "en";

    @CassandraType(userTypeName = "location_type", type = CassandraType.Name.UDT)
    @Column("lives_at")
    private Location livesAt;
    @Column("lives_at_text")
    private String livesAtText;
    @CassandraType(userTypeName = "address_type", type = CassandraType.Name.UDT)
    @Column("lives_at_address")
    private Address livesAtAddress;

    @CassandraType(userTypeName = "location_type", type = CassandraType.Name.UDT)
    @Column("lived_at")
    private Set<Location> livedAt;
    @Column("lived_at_text")
    private Set<String> livedAtTexts;
    @CassandraType(userTypeName = "address_type", type = CassandraType.Name.UDT)
    @Column("lived_at_address")
    private Set<Address> livedAtAddresses;

    @CassandraType(userTypeName = "location_type", type = CassandraType.Name.UDT)
    @Column("studying_at")
    private Location studyingAt;
    @Column("studying_at_name")
    private String studyingAtName;
    @CassandraType(userTypeName = "address_type", type = CassandraType.Name.UDT)
    @Column("studying_at_address")
    private Address studyingAtAddress;

    @CassandraType(userTypeName = "location_type", type = CassandraType.Name.UDT)
    @Column("studied_at")
    private Set<Location> studiedAt;
    @Column("studied_at_names")
    private Set<String> studiedAtNames;
    @CassandraType(userTypeName = "address_type", type = CassandraType.Name.UDT)
    @Column("studied_at_addresses")
    private Set<Address> studiedAtAddresses;

    @CassandraType(userTypeName = "location_type", type = CassandraType.Name.UDT)
    @Column("works_at")
    private Location worksAt;
    @Column("works_at_name")
    private String worksAtName;
    @CassandraType(userTypeName = "address_type", type = CassandraType.Name.UDT)
    @Column("works_at_address")
    private Address worksAtAddress;

    @CassandraType(userTypeName = "location_type", type = CassandraType.Name.UDT)
    @Column("worked_at")
    private Set<Location> workedAt;
    @Column("worked_at_names")
    private Set<String> workedAtNames;
    @CassandraType(userTypeName = "address_type", type = CassandraType.Name.UDT)
    @Column("worked_at_addresses")
    private Set<Address> workedAtAddresses;

    @Column("profile_summary")
    private String profileSummary;

    @Column("roles")
    private Set<String> roles;

    @Column("password")
    private String password;

    @Column("temporary_password")
    private String temporaryPassword;

    @Column("is_temporary_password_changed")
    private boolean isTemporaryPasswordChanged;

    @Column("is_deleted")
    private boolean isDeleted;

    @Column("is_active")
    private boolean isActive;

    @Column("last_active_location")
    private String lastActiveLocation;

    @Column("last_login_location")
    private String lastLoginLocation;

    @Column("last_login_at")
    private Date lastLoginAt;

    @Column("created_at")
    private Date createdAt;

    @Column("created_by")
    private String createdBy;

    @Column("modified_at")
    private Date modifiedAt;

    @Column("modified_by")
    private String modifiedBy;

    @CassandraType(userTypeName = "person_page_type", type = CassandraType.Name.UDT)
    @Column("owned_pages")
    private Set<PersonPage> ownedPages;

    @CassandraType(userTypeName = "following_type", type = CassandraType.Name.UDT)
    @Column("followings")
    private Set<Following> followings;

    @CassandraType(userTypeName = "person_group_type", type = CassandraType.Name.UDT)
    @Column("admin_groups")
    private Set<PersonGroup> adminGroups;

    @CassandraType(userTypeName = "person_group_type", type = CassandraType.Name.UDT)
    @Column("member_groups")
    private Set<PersonGroup> memberGroups;

    @CassandraType(userTypeName = "follower_type", type = CassandraType.Name.UDT)
    @Column("followers")
    private Set<Follower> followers;

    @CassandraType(userTypeName = "connection_type", type = CassandraType.Name.UDT)
    @Column("connections")
    private Set<Connection> connections;

    @CassandraType(userTypeName = "person_liked_post_type", type = CassandraType.Name.UDT)
    @Column("person_liked_posts")
    private Set<PersonLikedPost> personLikedPosts;

    @CassandraType(userTypeName = "person_shared_post_type", type = CassandraType.Name.UDT)
    @Column("person_shared_posts")
    private Set<PersonSharedPost> personSharedPosts;

    public Double getSocialPoints() {
        SocialPointsStrategyHandlerData data = new SocialPointsStrategyHandlerData(this);
        ChainOfResponsibilityUtils.getGenerateSocialPointsHandler().handleRequest(data);
        return data.getResponse();
    }

}
