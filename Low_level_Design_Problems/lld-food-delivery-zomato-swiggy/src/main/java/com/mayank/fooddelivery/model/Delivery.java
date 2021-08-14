package com.mayank.fooddelivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class Delivery {
    private String id;
    private String deliveryBoyId;
    private String userId;
    private String orderId;
    private Date deliveryTime;
}
