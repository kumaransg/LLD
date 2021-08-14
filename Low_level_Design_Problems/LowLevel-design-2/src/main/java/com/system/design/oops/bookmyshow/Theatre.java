package com.system.design.oops.bookmyshow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Theatre {
    private String name;
    private String TheatreId;
    private String cityId;
    private Address address;
}
