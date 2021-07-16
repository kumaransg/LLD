Property Hunt

Problem Statement

Build a console application for a Property Management Business where you can expose features like register a property, list a property and search properties based on your requirements. 


Feature Requirements

Register a User: One time registration of the User.

List a property: Users can list the properties they want to sell.

View listed properties: Users can view properties listed by them.

Shortlist a property: Users can short list properties they are interested in.

View shortlisted properties: Users can list properties they have shortlisted (including sold but with the status should be “SOLD”)

Search properties: Users can search for listed properties (only available properties should appear in results). They can use a combination of:

Location (case insensitive exact match would suffice for search).

Price range.

ListingType: Sell/Rent

Size range.

The number of rooms: 1BHK, 2BHK, 3BHK.

Sort by: It could be price or size (only ascending order is required).

Users can choose any set of parameters above for search.

Mark Sold: Users can mark a property as SOLD which was listed by them.


Bonus Requirements 

Accept size in multiple units (sq. meter, sq. ft. & sq. yard). A seller and a buyer can provide the size in different units while listing and searching properties.

Accept a number of locations as nearby locations for a property listing and search should list properties with search locations in nearby places also (here sort by location can also be provided and such properties which are a match in nearby locations, should appear last).

Accept price in multiple forms (40000, 40k, 2Cr, 60L, etc.) during the listing or searching.

For location and number of rooms, accept “,” separated values during the search.


Guidelines

Input can be read from a file or STDIN or coded in a driver method.

Output can be written to a file or STDOUT.

Store all interim/output data in-memory. The usage of databases is not allowed.

Restrict internet usage to looking up syntax.

You are free to use the language of your choice.

Save your code/project by your name and email it. Your program will be executed on another machine. So, explicitly specify dependencies, if any, in your email.


Expectations

The code should be demo-able (very important). The code should be functionally correct and complete.

At the end of this interview round, an interviewer will provide multiple inputs to your program for which it is expected to work 

The code should handle edge cases properly and fail gracefully. Add suitable exception handling, wherever applicable.

An example would be to display an error message saying “Property does not exist” when the user is trying to shortlist a property.

The code should have a good object-oriented design.

The code should be readable, modular, testable, and extensible. Use intuitive names for your variables, methods, and classes.

It should be easy to add/remove functionality without rewriting a lot of code.

Do not write a monolithic code.

Don’t use any databases.


Sample test cases

Input and Output (You may change the input-output format without changing the functionality to suit your needs):

→ is input

← is output



Register user:

-> Jack

<- User registered successfully.


Register property: (user name, property name, location, price, type, size, number of rooms)

-> Jack, A 3BHK for sale, bellandur, 90L,sell, 1800 sqft, 3

<- Property listed successfully.

-> Jack, A 2BHK for rent, sarjapur, 40k ,rent, 1500 sq ft, 2

<- Property listed successfully.


Search property: (location, price range, type, size, number of rooms, sort on)

-> bellandur, 30000-50000, rent, 150sqft, 2, price


← Id	Title			Location	Price	Size	Rooms	AvailableFor

← 2	A 2BHK for rent 	sarjapur 	40k 	1500sqf 2BHK	Rent


Shortlist property:(user name, property id)

-> Jack, 2

<- Shortlisted property


View shortlisted: (user name)

-> Jack

← Id	Title			Location	Price	Size	Rooms	AvailableFor	Status

← 2	A 2BHK for rent 	sarjapur 	40k 	1500sqf 2BHK	Rent		Available


Search

-> null, null, null, null, null, null

← Id	Title			Location	Price	Size	Rooms	AvailableFor

← 1	A 3BHK for sale	bellandur	90L	1800sqf 3BHK	Sale

← 2	A 2BHK for rent 	sarjapur 	40k 	1500sqf 2BHK	Rent
