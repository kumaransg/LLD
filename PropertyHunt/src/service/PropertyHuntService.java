package service;

import enums.ListingType;
import enums.RoomType;

/*
    the service class which exposes API to clients
 */
public interface PropertyHuntService {

    /**
     * The current user can list the property using this API
     */
    void listProperty(String propertyId, String propertyTitle, String location, String price, ListingType listingType,
        String size,
        RoomType roomType);

    /**
     * user can shortlist property
     */
    void shortListProperty(String propertyID);

    /**
     * view a list of property shortListed by the current user
     */
    void viewShortListProperty();

    /**
     * gets the list of property listed by the current user
     */
    void viewListedProperty();

    /**
     * marks the property as sold
     */
    void markAsSold(String propertyId, String soldTo, String soldPrice);

    /**
     * user can search the property using various paramters
     */
    void searchProperty(String location, String price, ListingType listingType, String size, RoomType roomType);

    /**
     * login a user and provides a UUID back, which can used for other calls
     */
    String loginUser(String name);
}
