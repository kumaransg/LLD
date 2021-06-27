package model.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
@Builder
public class Contact {
    private String countryCode;
    private String email;
    private String phoneNumber;
}
