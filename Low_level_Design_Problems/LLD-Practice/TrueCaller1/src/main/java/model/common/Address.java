package model.common;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String street;
    private String city;
    private String country;
    private String pinCode;
}
