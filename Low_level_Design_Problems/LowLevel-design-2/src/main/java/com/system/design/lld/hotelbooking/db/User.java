package com.system.design.lld.hotelbooking.db;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int userId;
    private String name;
    private String emailId;
    private String phoneNumber;
    private String address;
}
