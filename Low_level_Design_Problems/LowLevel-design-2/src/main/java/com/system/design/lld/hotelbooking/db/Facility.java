package com.system.design.lld.hotelbooking.db;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Facility {
    private int facilityId;
    private String name;
}
