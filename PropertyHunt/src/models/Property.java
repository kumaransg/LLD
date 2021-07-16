package models;

import enums.ListingType;
import enums.RoomType;


public class Property {

    //UUID
    String propertyID;
    String propertyTitle;
    String location;
    String price;
    ListingType listingType;
    String PropertySize;
    RoomType roomType;
    boolean isPropertySold;
    PropertySold propertySoldDetails;

    public Property(String propertyID,String propertyTitle, String location, String price, ListingType listingType,
        String propertySize, RoomType roomType) {
        this.propertyID = propertyID;
        this.propertyTitle = propertyTitle;
        this.location = location;
        this.price = price;
        this.listingType = listingType;
        PropertySize = propertySize;
        this.roomType = roomType;
        this.isPropertySold = false;
        propertySoldDetails = new PropertySold();
    }

    public String getPropertyID() {
        return propertyID;
    }

    private void setPropertySold(boolean propertySold) {
        isPropertySold = propertySold;
    }

    public void markPropertyAsSold(String soldTo, int soldPrice) {
        if(isPropertySold){
            throw  new RuntimeException("property Sold already");
        }
        setPropertySold(true);
        propertySoldDetails.setSoldto(soldTo);
        propertySoldDetails.setSoldPrice(soldPrice);
    }

    public String getPropertyTitle() {
        return propertyTitle;
    }

    public String getLocation() {
        return location;
    }

    public String getPrice() {
        return price;
    }

    public ListingType getListingType() {
        return listingType;
    }

    public String getPropertySize() {
        return PropertySize;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public boolean isPropertySold() {
        return isPropertySold;
    }
}
