package model.common;

import lombok.Builder;
import lombok.Value;

@Builder(builderMethodName = "hiddenBuilder")
@Value
public class PersonalInfo {
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private Address address;
    private String company;

    public static PersonalInfoBuilder builder(String firstName){
        return hiddenBuilder().firstName(firstName);
    }
}
