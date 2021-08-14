## Design Parking lot

![Image of Parking lot](https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Subterranean_parking_lot.jpg/2880px-Subterranean_parking_lot.jpg)

Parking lot has multiple floors, multiple entry and exit points.  
Entry is recorded at entry point and payment is done at the time of exit.  
Parking lot contains Multiple floors.  
Parking floor containts multiple parking slots which are of different types.  
 1. HANDICAPPED
 2. CAR
 3. LARGE
 4. MOTORBIKE
 5. ELECTRIC
 6. EBIKE

Parking is on first come first served basis.  
Time is recorded at the time of issuing the ticket in entry panel.  
Time is recorded at the exit panel and charges are calculated at that point of time.  
User should be able to pay for the ticket.  
Admin should be able to add floor to the lot.  
Admin shoul be able to add parking slots to the floor.  
Admin should be able to remove a slot.  
Admin should be able to add etrance and exit panels.  
User should not be issued a ticket if the slot is not available.  
As the user is allocated a slot the inventory of the slots gets reduced.  
Add user leaves the parking the inventory get updated.  

# Admin Test cases
Admin Case 1 - should be able to add parking floor case  
Admin Case 2 - should be able to add parking floor case  
Admin Case 3 - should be able to add entrance panel  
Admin Case 4 - should be able to add exit panel  
Admin case 5 - should be able to add car parking spot  
Admin case 6 - should be able to add bike parking spot  
Admin case 7 - should be able to add car parking spot  

#User Test cases
Test case 1 - check for availability of parking lot - TRUE  
Test case 2 - check for availability of parking lot - FALSE  
Test case 3 - check for availability of parking lot - FALSE  
TEST case 4 - Check if full  
Test case 5 - get parking spot  
Test case 6 - should not be able to get spot  
Test case 7 - Entrance Panel - 1  
Test case - 8 - Should be able to get parking ticket  
Test case - 9 - Should be able to get parking ticket  
Test case 10 - Should not be able to get ticket  
Test case 11 - Should be able to get ticket  
Test case 12 - vacate parking spot  
Test case 13 - park on vacated spot  
Test case 14 - park when spot is not available  
Test cast 15 - vacate car  
Test case 16 - Now should be able to park car  
Test case 17 - Should be able to vacate parked vehicle  
Test case 18 - check for slots count  
Test case 19 - Payment  
Test case 20 - vacate motorbike spot  