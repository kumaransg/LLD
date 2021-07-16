package Util;

import enums.ListingType;
import enums.RoomType;
import models.Property;

import java.util.ArrayList;
import java.util.List;

/*
Search util class which searches based on different parameters;
 */
public class SearchPropertyUtil {
    public static List<Property> filterByLocation(String location, List<Property> propertyList){
        ArrayList<Property> list = new ArrayList<>();
        for(Property property : propertyList){
            if(property.getLocation().equals(location.toLowerCase())){
                list.add(property);
            }
        }
        return list;
    }


    public static List<Property> filterByListingType(ListingType listingType,List<Property> propertyList){
        ArrayList<Property> list = new ArrayList<>();
        for(Property property : propertyList){
            if(property.getListingType().equals(listingType)){
                list.add(property);
            }
        }
        return list;
    }

    public static List<Property> filterByNumberOfRooms(RoomType roomType,List<Property> propertyList){
        ArrayList<Property> list = new ArrayList<>();
        for(Property property : propertyList){
            if(property.getListingType().equals(roomType)){
                list.add(property);
            }
        }
        return list;
    }

}
