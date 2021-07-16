package com.system.design.lld.hotelbooking.db;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomTypeFacility {
    private int roomTypeFeatureId;
    private int facilityId;
    private int roomTypeId;
}
