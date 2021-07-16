import enums.ListingType;
import enums.RoomType;
import service.PropertyHuntService;
import service.PropertyHuntServiceImpl;

public class PropertyHutApplication {
    public static void main(String[] args) {
        PropertyHuntService propertyHuntService = new PropertyHuntServiceImpl();

        // login user (1 api)
        String currentUser = propertyHuntService.loginUser("testUser1");
        System.out.println(currentUser);

        //list property (2 api)
        propertyHuntService
            .listProperty("112","A 3BHK for sale", "bellandur", "90L", ListingType.SELL, "1800sq", RoomType.THREEBHK);

        propertyHuntService
            .listProperty("113","A 2BHK for sale", "sarjapura", "40k", ListingType.RENT, "1500sq", RoomType.TWOBHK);
        // view list property by the user (3 api)
        propertyHuntService.viewListedProperty();


        // shortlist a property and view that property
        propertyHuntService.shortListProperty("112"); // (4 api)
        propertyHuntService.viewShortListProperty(); //(5 api)

        // 6 api
//        propertyHuntService.markAsSold("113","user2","100000");
        propertyHuntService.viewListedProperty();

        //7 api
        propertyHuntService.searchProperty("bellandur","90L",ListingType.SELL,"1800sq",RoomType.THREEBHK);


        currentUser = propertyHuntService.loginUser("testUser2");
        propertyHuntService
            .listProperty("154","A 3BHK for sale3", "bellandur", "90L", ListingType.SELL, "1800sq", RoomType.THREEBHK);

        propertyHuntService.viewListedProperty();


        currentUser = propertyHuntService.loginUser("testUser1");

        propertyHuntService.markAsSold("113","user2","100000");

        propertyHuntService.searchProperty(null,"",null,"",null);

//        propertyHuntService
//            .listProperty("112","A 3BHK for sale", "bellandur", "90L", ListingType.SELL, "1800sq", RoomType.THREEBHK);


    }
}
