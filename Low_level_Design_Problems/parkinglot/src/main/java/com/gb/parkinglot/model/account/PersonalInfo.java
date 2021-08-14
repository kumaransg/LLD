package com.gb.parkinglot.model.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalInfo {
    private String firstName;
    private String lastName;
    private String middleName;
    private String initials;
    private String dob;
}
