package dao;

import exceptions.PropertyNotAvailable;
import models.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/*
    singleton class, to store all the in-memory Data
 */
public class PropertyHuntDao {
    // list of Property for Each user ID;
    private HashMap<String, List<Property>> userPropertyMap;
    // list of Shortlist property against each user ID.
    private HashMap<String, List<Property>> userShortlistedMap;

    private HashMap<String, Property> listOfAvailableProperty;

    private String currentUserId;

    private static PropertyHuntDao propertyHuntDaoInstance;

    private PropertyHuntDao() {
        this.userPropertyMap = new HashMap<>();
        this.userShortlistedMap = new HashMap<>();
        listOfAvailableProperty = new HashMap<>();
    }

    public static PropertyHuntDao getInstance() {
        if (propertyHuntDaoInstance == null) {
            propertyHuntDaoInstance = new PropertyHuntDao();
        }
        return propertyHuntDaoInstance;
    }

    public void addProperty(Property property) {
        if (property != null) {
            if (!userPropertyMap.containsKey(currentUserId)) {
                userPropertyMap.put(currentUserId, new ArrayList<>());
            }
            userPropertyMap.get(currentUserId).add(property);

            // add it to avaliable property
            listOfAvailableProperty.put(property.getPropertyID(), property);
        }
    }

    public Property getProperty(String propertyId) {
        if (!listOfAvailableProperty.containsKey(propertyId)) {
            throw new PropertyNotAvailable("Property with the property ID not present");
        }
        return listOfAvailableProperty.get(propertyId);
    }

    public void shortListPropertyForCurrentUser(String propertyId) {
        if (!listOfAvailableProperty.containsKey(propertyId)) {
            throw new PropertyNotAvailable("Property with the property ID not present");
        }
        Property property = listOfAvailableProperty.get(propertyId);
        if (!userShortlistedMap.containsKey(currentUserId)) {
            userShortlistedMap.put(currentUserId, new ArrayList<>());
        }
        userShortlistedMap.get(currentUserId).add(property);
    }

    //get list of property for current User
    public List<Property> getListedProperty() {
        if (userPropertyMap.containsKey(currentUserId)) {
            return new ArrayList<>(userPropertyMap.get(currentUserId));
        }
        return new ArrayList<>();
    }

    public List<Property> getShortListedProperty() {
        if (userShortlistedMap.containsKey(currentUserId)) {
            return userShortlistedMap.get(currentUserId);
        }
        return new ArrayList<>();
    }

    public String loginNewUser(String userId){
        currentUserId = userId;
        return currentUserId;
    }

    public HashMap<String, Property> getListOfAvailableProperty() {
        return new HashMap<>(listOfAvailableProperty);
    }
}
