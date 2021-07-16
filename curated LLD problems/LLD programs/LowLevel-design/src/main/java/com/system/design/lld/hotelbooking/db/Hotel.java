package com.system.design.lld.hotelbooking.db;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hotel {
    private int hotelId;
    private String name;
    private String address;
}
