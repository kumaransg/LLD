Foodkart:

Description:

Flipkart is starting a new online food ordering service. In this Service, users can order food from a restaurant which is serviceable in their area and the restaurant will deliver it.
Features:

Restaurants can only serve one specialized dish.
Restaurants can serve in multiple areas.
At a time, users can order from one restaurant, and the quantity of food can be more than one.
Users should be able to rate any restaurant with or without comment.
Rating of a restaurant is the average rating given by all customers.
Requirements:

Register a User:
register_user(user_details) 

user_details: name, gender, phoneNumber(unique) and pincode.

Users should be able to login, and all the operations will happen in the context of that user. If another user logged in, the previous user will automatically be logged out.
login_user(user_id):  this should set the context for all the next operation to be done by this user.
Register a restaurant in context of login user:
Register_restaurant(resturant_name, list of serviceable pin-codes, food item  name, food item price, initial quantity).
Restaurant owners should be able to increase the quantity of the food item.
update_quantity(restaurant name, quantity to Add)
Users should be able to rate(1(Lowest)-5(Highest)) any restaurant with or without comment.
rate_restaurant(restaurant name, rating, comment)
User should be able to get list of all serviceable restaurant, food item name and price in descending order: show_restaurant(rating/price)
Based on rating
Based on Price
NOTE: A restaurant is serviceable when it delivers to the user's pincode and has non-zero quantity of food item.
Place an order from any restaurant with any allowed quantity.
place_order(restaurant name, quantity)
Bonus:
Order History of User: For a given user you should be able to fetch order history.
Other Details:
Do not use any database or NoSQL store, use in-memory store for now. 
Do not create any UI for the application.
Write a driver class for demo purposes. Which will execute all the commands at one place in the code and test cases.
Please prioritize code compilation, execution and completion.
Please do not access the internet for anything EXCEPT syntax.
You are free to use the language of your choice.
All work should be your own. If found otherwise, you may be disqualified.
Expectations:
Code should be demoable (very important)
Complete coding within the duration of 90 minutes.
Code should be modular, with Object Oriented design. Maintain good separation of concerns.
Code should be extensible. It should be easy to add/remove functionality without rewriting the entire codebase.
Code should handle edge cases properly and fail gracefully.
Code should be readable. Follow good coding practices:
Use intuitive variable names, function names, class names etc.
Indent code properly.
Once the code is complete please zip the source code and upload it to:  https://docs.google.com/forms/d/e/1FAIpQLSfzz8HH6fLso7NLgqJ0kC0TYP-tZhC2XhTN4EdI2c6OC1v2XA/viewform
Sample Test Case:
All the inputs here are just indicating the high level inputs that function should accept. You are free to model entities as per your choice.

register_user(“Pralove”, “M”, “phoneNumber-1”, “HSR”)
register_user(“Nitesh”, “M”, “phoneNumber-2”, “BTM”)
register_user(“Vatsal”, “M”,  “phoneNumber-3”, “BTM”)

login_user(“phoneNumber-1”)

register_restaurant(“Food Court-1”, “BTM/HSR”, “NI Thali”, 100, 5)
NOTE: we will have 2 delimiters in input : ',' to specify separate fields & '/' to identify different pincodes.
register_restaurant(“Food Court-2”, “BTM”, “Burger”, 120, 3)

login_user(“phoneNumber-2”)
register_restaurant(“Food Court-3”, “HSR”, “SI Thali”, 150, 1)
login_user(“phoneNumber-3”)
show_restaurant(“price”)

Output :  Food Court-2, Burger
	   Food Court-1, NI Thali

place_order(“Food Court-1”, 2)
Output: Order Placed Successfully.

place_order(““Food Court-2”, 7)
Output : Cannot place order

create_review(“Food Court-2”, 3, “Good Food”)
create_review(“Food Court-1”, 5, “Nice Food”)

show_restaurant(“rating”)
Output :  Food Court-1, NI Thali
	   Food Court-2, Burger

login_user(“phoneNumber-1”)
update_quantity(“Food Court-2”, 5)
Output: Food Court-2, BTM, Burger - 8

update_location(“Food Court-2”, “BTM/HSR”)
Output: Food Court-2, “BTM/HSR”, Burger - 8



https://docs.google.com/document/d/1Bmkz9omByHqVvwU45cvkBRSwJAPKw9yaDsRlEnCg_lg/edit#
