package com.mayank.fooddelivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class FoodMenu {
    private String id;
    private List<String> restaurantIds;
    private List<MenuItem> menuItemList;
}
