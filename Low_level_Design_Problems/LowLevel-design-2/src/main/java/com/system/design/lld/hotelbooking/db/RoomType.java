package com.system.design.lld.hotelbooking.db;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomType {
    private int roomTypeId;
    private String roomTypeName;
    private int capacity;
    private int price;
    private int roomSize;
}
