package com.system.design.oops.bookmyshow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hall {
    private String hallId;
    private String threatreId;
    private int totalCapacity;
}
