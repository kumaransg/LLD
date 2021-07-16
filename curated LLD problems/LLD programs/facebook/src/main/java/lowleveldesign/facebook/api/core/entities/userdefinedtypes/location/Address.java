package lowleveldesign.facebook.api.core.entities.userdefinedtypes.location;

import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.Apartment;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.Area;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.Building;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.City;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.Country;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.District;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.House;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.Pincode;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.PoliceStation;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.State;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.SubDistrict;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("address_type")
public class Address {

    @CassandraType(userTypeName = "house_type", type = CassandraType.Name.UDT)
    @Column("house")
    private House house;
    @Column("house_number")
    private String houseNumber;

    @CassandraType(userTypeName = "building_type", type = CassandraType.Name.UDT)
    @Column("building")
    private Building building;
    @Column("building_number")
    private String buildingNumber;

    @CassandraType(userTypeName = "apartment_type", type = CassandraType.Name.UDT)
    @Column("apartment")
    private Apartment apartment;
    @Column("apartment_name")
    private String apartmentName;

    @CassandraType(userTypeName = "area_type", type = CassandraType.Name.UDT)
    @Column("area")
    private Area area;
    @Column("area_name")
    private String areaName;

    @CassandraType(userTypeName = "city_type", type = CassandraType.Name.UDT)
    @Column("city")
    private City city;
    @Column("city_name")
    private String cityName;

    @CassandraType(userTypeName = "pincode_type", type = CassandraType.Name.UDT)
    @Column("pincode")
    private Pincode pincode;
    @Column("pincode_number")
    private String pincodeNumber;

    @CassandraType(userTypeName = "police_station_type", type = CassandraType.Name.UDT)
    @Column("police_station")
    private PoliceStation policeStation;
    @Column("police_station_name")
    private String policeStationName;

    @CassandraType(userTypeName = "sub_district_type", type = CassandraType.Name.UDT)
    @Column("sub_district")
    private SubDistrict subDistrict;
    @Column("sub_district_name")
    private String subDistrictName;

    @CassandraType(userTypeName = "district_type", type = CassandraType.Name.UDT)
    @Column("district")
    private District district;
    @Column("district_name")
    private String districtName;

    @CassandraType(userTypeName = "state_type", type = CassandraType.Name.UDT)
    @Column("state")
    private State state;
    @Column("state_name")
    private String stateName;

    @CassandraType(userTypeName = "country_type", type = CassandraType.Name.UDT)
    @Column("country")
    private Country country;
    @Column("country_name")
    private String countryName;

}
