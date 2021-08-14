package com.system.design.lld.hotelbooking.db;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {
    private int addressId;
    private int userId;
    private String address1;
    private String address2;
}
