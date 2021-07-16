package service;

import UI.PropertyHutDisplay;
import Util.SearchPropertyUtil;
import dao.PropertyHuntDao;
import enums.ListingType;
import enums.RoomType;
import models.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyHuntServiceImpl implements PropertyHuntService {

    PropertyHuntDao propertyHuntDao;

    public PropertyHuntServiceImpl() {
        this.propertyHuntDao = PropertyHuntDao.getInstance();
    }

    @Override
    public void listProperty(String propertyID, String propertyTitle, String location, String price,
        ListingType listingType,
        String propertySize,
        RoomType roomType) {
        HashMap<String, Property> propertyList = propertyHuntDao.getListOfAvailableProperty();
        if (propertyList.containsKey(propertyID)) {
            throw new RuntimeException("property Already list by this ID");
        }
        Property property = new Property(propertyID, propertyTitle, location, price, listingType, propertySize,
            roomType);
        // add the property to current user;
        propertyHuntDao.addProperty(property);
        System.out.println("List Created successfully for the propertyTitle : " + propertyTitle);
    }

    @Override
    public void shortListProperty(String propertyID) {
        Property property = propertyHuntDao.getProperty(propertyID);
        if (property != null) {
            propertyHuntDao.shortListPropertyForCurrentUser(propertyID);
        }
    }

    @Override
    public void viewShortListProperty() {
        List<Property> listOfShortListed = propertyHuntDao.getListedProperty();
        PropertyHutDisplay.displayProperty(listOfShortListed);

    }

    @Override
    public void viewListedProperty() {
        List<Property> listOfPropertyListed = propertyHuntDao.getListedProperty();
        PropertyHutDisplay.displayProperty(listOfPropertyListed);
    }

    @Override
    public void markAsSold(String propertyId, String soldTo, String soldPrice) {
        List<Property> propertyList = propertyHuntDao.getListedProperty();
        boolean canPropertyBeSold = false;
        for (Property property : propertyList) {
            if (property.getPropertyID() == propertyId) {
                canPropertyBeSold = true;
                break;
            }
        }
        if (!canPropertyBeSold) {
            throw new RuntimeException("property can't be sold as your are a different user");
        }
        Property property = propertyHuntDao.getProperty(propertyId);
        if (property != null) {
            property.markPropertyAsSold(soldTo, Integer.valueOf(soldPrice));
        }
    }

    @Override
    public void searchProperty(String location, String price, ListingType listingType, String size, RoomType roomType) {
        // get the list of all available property
        HashMap<String, Property> map = propertyHuntDao.getListOfAvailableProperty();
        List<Property> propertyList = new ArrayList<>();
        for (Map.Entry<String, Property> entry : map.entrySet()) {
            propertyList.add(entry.getValue());
        }
        // chain the list of parameters to filter Util class
        if (location != null && !location.equals(""))
            propertyList = SearchPropertyUtil.filterByLocation(location, propertyList);
        if (listingType != null)
            propertyList = SearchPropertyUtil.filterByListingType(listingType, propertyList);
        //finally display
        PropertyHutDisplay.displayProperty(propertyList);
    }

    @Override
    public String loginUser(String userId) {
        System.out.println("Current user logged in : " + userId);
        return propertyHuntDao.loginNewUser(userId);
    }

}
