##Requirements:

1.  Application should allow user onboarding.
    add_user(user_detail)

2.  Add basic user details
    add_vehicle(vehicle_detail)

3.  Add the user’s vehicle(s) details

4.  User should be able to offer a shared ride on a route with details.
    offer_ride(ride_detail)

5.  Ride will have details like vehicle, origin, destination, available seats. (A ride will have no intermediate stops.)

6.  Users can select a ride from multiple offered rides using a selection strategy. (A user can only request  a ride (only for 1 or 2 people))
    select_ride(source, destination, seats, selection_strategy)
    Prefered Vehicle (Activa/Polo/XUV)
    Most Vacant.

7.  System should be able to end the ride. User can only offer a ride for a given vehicle, once there are no active offered rides for that vehicle.
    end_ride(ride_details)

8.  Find total rides offered/taken by all users.
    print_ride_stats()
    
    
##Sample Test Cases:
    
    1. Onboard 5 users
    
    add_user(“Rohan, M, 36”); add_vehicle(“Rohan, Swift, KA-01-12345)
    
    add_user(“Shashank, M, 29”); add_vehicle(“Shashank, Baleno, TS-05-62395)
    
    add_user(“Nandini, F, 29)  
    
    add_user(“Shipra, F, 27”) ; add_vehicle(“Shipra”, Polo, KA-05-41491); add_vehicle(“Shipra, Activa KA-12-12332”)
    
    add_user(“Gaurav, M, 29)
    
    add_user(“Rahul, M, 35); add_vehicle(“Rahul”, “XUV”, KA-05-1234);
    
    2. Offer 4 rides by 3 users
    
    offer_ride(“Rohan, Origin=Hyderabad, Available Seats=1, Vehicle=Swift, KA-01-12345, Destination= Bangalore”)
    
    offer_ride(“Shipra, Origin=Bangalore, Available Seats=1, Vehicle=Activa KA-12-12332, Destination=Mysore”)
    
    offer_ride(“Shipra, Origin=Bangalore, Available Seats=2, Vehicle=Polo, KA-05-41491, Destination=Mysore”)
    
    offer_ride(“Shashank, Origin=Hyderabad, Available Seats=2, Vehicle=Baleno, TS-05-62395, Destination=Bangalore”)
    
    offer_ride(“Rahul, Origin=Hyderabad, Available Seats=5, Vehicle=XUV,  KA-05-1234, Destination=Bangalore”)
    
    offer_ride(“Rohan, Origin=Bangalore, Available Seats=1, Vehicle=Swift, KA-01-12345, Destination=Pune”)
    
    This call should fail, since a ride has already been offered by this user for this vehicle.
    
    3. Find rides for 4 users
    
    select_ride(“Nandini, Origin=Bangalore, Destination=Mysore, Seats=1, Most Vacant”)
    
    2(c) is the desired output.
    
    select_ride(“Gaurav, Origin=Bangalore, Destination=Mysore, Seats=1, Preferred Vehicle=Activa”)
    
    2(b) is the desired output
    
    select_ride(“Shashank, Origin=Mumbai, Destination=Bangalore, Seats=1, Most Vacant”)
    
    No rides found
    
    select_ride(“Rohan, Origin=Hyderabad, Destination=Bangalore, Seats=1, Preferred Vehicle=Baleno”)
    
    2(d) is the desired output
    
    select_ride(“Shashank, Origin=Hyderabad, Destination=Bangalore, Seats=1,Preferred Vehicle=Polo”)
    
    No rides found
    
    4. End Rides
    
    end_ride(2-a)
    
    end_ride(2-b)
    
    end_ride(2-c)
    
    end_ride(2-d)
    
    5. Find total rides by user: Rides Taken: Rides that have were taken and have been marked as “ended” Rides Offered: Rides that were offered and have been marked as “ended”. Note: Even if the offered ride was not taken by any user, it counts as an offered ride.
    
    print_ride_stats()
    
    Nandini: 1 Taken, 0 Offered  
    
    Rohan: 1 Taken, 1 Offered 
    
    Shashank: 0 Taken, 1 Offered 
    
    Gaurav: 1 Taken, 0 Offered
    
    Rahul: 0 Taken, 0 Offered 
    
    Shipra: 0 Taken, 2 Offered