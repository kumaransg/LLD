
Stock Exchange
--------------

Implement an order matching system for a stock exchange.

Traders place Buy and Sell orders for a stock indicating the price and quantity.

Each order gets entered into the exchange’s order-book and remains there until it is matched. Order matching is attempted whenever a new order is added.

The exchange follows a FirstInFirstOut Price-Time order-matching rule, which states that: “The first order in the order-book at a price level is the first order matched. All orders at the same price level are filled according to time priority”.

The exchange works like a market where lower selling prices and higher buying prices get priority.

A trade is executed when a buy price is greater than or equal to a sell price. The trade is recorded at the price of the sell order regardless of the price of the buy order.

Write a program that accepts orders from standard input and writes trades to standard output.

e.g. The following input (format:<order-id> <time> <stock> <buy/sell> <price> <qty>):

#1 09:45 BAC sell 240.12 100

#2 09:46 BAC sell 237.45  90 

#3 09:47 BAC buy  238.10 110 

#4 09:48 BAC buy  237.80  10

#5 09:49 BAC buy  237.80  40

#6 09:50 BAC sell 236.00  50

Should produce the following output (format:<buy-order-id> <sell-price> <qty> <sell-order-id>):

#3 237.45 90 #2

#3 236.00 20 #6

#4 236.00 10 #6

#5 236.00 20 #6

Input needs to be read from a text file, and output should be printed to console. Your program should execute and take the location to the test file as parameter.

You can read build instructions here - https://github.com/geektrust/coding-problem-artefacts


