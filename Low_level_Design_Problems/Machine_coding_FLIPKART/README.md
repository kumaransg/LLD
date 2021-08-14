# Machine_coding FLIPKART
## Error Finder Application Problem Statement



Q)Given a binary tree as a sequence of (parent, child) tuples: (A B)(A C)(B G)(C H)(E F)(B D)(C E) Write a program to find following errors in the tree:



- E1: More than 2 children
- E2: Duplicate Tuples
- E3: Cycle present
- E4: Multiple roots
- E5: Multiple parents



Input is a expression containing parent child relations. output is Error codes or success.
Sample test cases
- Input: (A B)(A C)(B G)(C H)(E F)(B D)(C E) Output: Success
- Input: (A B)(A C)(A D) Output: E1
- Input: (A B)(A B) Output: E2
- Input: (A B)(B C)(C A) Output: E3
- Input: (A B)(C D) Output: E4
- Input: (A B)(B C)(A C) Output: E5

```diff
+ Solution: Code can be found in ErrorFinderApplication.zip, written in java.
```
## Design a Ride Matching application 

Find all the eligible drivers for a rider cosidering below conditions. 

1. The average rating of the driver should be greater than the customer average rating.

2. If the customer had given the driver a 1 star rating earlier then this driver is not to be considered vice versa.
  (In average rating calculation this driver's rides are not cosidered for a rider.)

3. If there are no drivers found, print the ones for which the customer had rode earlier.

- Bonus: Show online drivers at any time. 

```diff
+ Solution: Code can be found in DriverAndRiderApplication.zip, written in java.
```

## Design an Ecommerce storage system

1. You can add a product -> addProduct(“p1”)
2. A user can purchase a product -> purchase(“u1″,”p1”)
3. A user can return a product -> returnProduct(“u1″,”p1”)
4. A user can be blacklisted and all of his purchases will be marked null -> blackListUser(“u1”)
5. Display the best selling product -> bestSelling()

- Best selling product will be the one which have been bought by most number of unique users.
- Bonus: Display the best selling products for each category.

```diff
+ Solution: Code can be found in OrderBookingSystem.zip, written in java.
```

## Implement a Text Line Editor which supports the following operations:

- insert a line at a given line number
- delete the specific set of lines
- Copy specific set of lines
- Paste the copied lines at given index
- Print the entire content

`Bonus`

1. Undo command
2. Redo command

```diff
+ Solution: Code can be found in TextPadApplication.zip, written in java.
```

## Pandemic Tracker

- Description:
There are many viral diseases reported all over the world. For example, in the past Ebola, Zika, Spanish Flu etc were reported and they spread over multiple countries. The most recent case is Covid-19 which has affected around 190 countries and is spreading very fast among the world population. These diseases usually start from one region and spread through various human/animal interactions in other regions. Governments all over the world want to control the spread of diseases by taking appropriate measures for which they need to track the disease at regional level first. You are required to create a pandemic tracker tool which will help to track the diseases.

### Features:
- Tracker should be able to track multiple diseases.
- Tracker should be able to capture positive cases at country, state and city level
- One patient can be infected with multiple diseases at a time
- Tracker should be able to capture cured cases for diseases as well as fatality cases.
- Tracker should be able to show stats at world level summary, country wise breakup summary, 
- Tracker should be able to show stats for a given country: country level summary, state wise breakup summary

### Requirements:
- Report as positive case in the tracker: report(disease, patient, region)
- Report a cured case in the tracker: cured(disease, patient)
- Report fatality case in the tracker: fatality(disease, patient)
- Show world level summary: Overall summary, diseases breakup summary
- Show country wise breakup summary for a given disease
- Show state wise breakup summary for a given disease in a country

### Bonus question:
For a country and a disease, show daily/weekly/monthly trends (for ease of testing consider day as seconds, week as minute, month as hour)

Other Details:
- Do not use any database or NoSQL store, use the in-memory store for now. 
- Do not create any UI for the application.
- Write a driver class for the demo purposes. Which will execute all the commands at one place in the code and test cases.
- Please prioritize code compilation, execution, and completion.
- Work on the expected output first and then add good-to-have features of your own.
- You can choose whatever input format you want as long as all the input parameters are part of it. You can also call the appropriate methods from a driver class to show a demo. 

### Expectations
- Create the sample data yourself. You can put it into a file, test case or main driver program itself.
- Code should be demoable. Either by using a main driver program or test cases.
- Code should be modular. Code should have basic OO design. Please do not jam in responsibilities of one class into another.
- Code should be extensible. Wherever applicable, use interfaces and contracts between different methods. It should be easy to add/remove functionality without re­writing entire codebase.
- Code should handle edge cases properly and fail gracefully.
- Code should be legible, readable and DRY

### Guidelines
- Please discuss the solution with an interviewer
- Please do not access internet for anything EXCEPT syntax
- You are free to use the language of your choice
- All code should be your own
- Please focus on the Bonus questions only after ensuring the required features are complete and demoable


### Test Cases:
(Test cases are defined for understanding feature requirements only. Please model it appropriately based on your service implementation)

- report(“COVID-19”, P1, “China”, “Hubei”, “Wuhan” )
- report(“COVID-19”, P2, “China”, “Hubei”, “Wuhan”)
- report(“COVID-19”, P3, “China”, “Jiangsu”, “Shanghai”)
- report(“COVID-19”, P4, “India”, “Uttar Pradesh”, “Agra”)
- report(“COVID-19”, P5, “India”, “Uttar Pradesh”, “Varanasi”)
- report(“COVID-19”, P6, “India”, “Karnataka”, “Bangalore”)
- report(“COVID-19”, P7, “India”, “Karnataka”, “Bangalore”)
- report(“COVID-19”, P8, “India”, “Karnataka”, “Bangalore”)
- report(“Spanish Flu”, P9, “USA”, “California”, “Los Angeles”)
- report(“Spanish Flu”, P10, “USA”, “California”, “San-francisco”)



ShowWorldSummary() => 
Overall:
Total : 10
Cured : 0
Fatality : 0
Active : 10




ShowWorldSummaryDiseasesBreakup() =>
COVID-19:
Total : 8
Cured : 0
Fatality : 0
Active : 8
Spanish Flu:
Total : 2
Cured : 0
Fatality : 0
Active : 2




ShowCountryBreakup(“COVID-19”) =>
China:
Total : 3
Cured : 0
Fatality : 0
Active : 3
India:
Total : 5
Cured : 0
Fatality : 0
Active : 5
ShowStateBreakup(“COVID-19”, “India”)
Uttar Pradesh:
Total : 2
Cured : 0
Fatality : 0
Active : 2
Karnataka:
Total : 3
Cured : 0
Fatality : 0
Active : 3
ShowTrends(“DAILY”, “COVID-19”, “India”, StartDate, EndDate)
Day1:
Total : 1
Cured : 0
Fatality : 0
Active : 1
Day2:
Total : 2
Cured : 0
Fatality : 0
Active : 2
Day3:
Total : 2
Cured : 0
Fatality : 0
Active : 2
cured(“COVID-19”, P8)




ShowWorldSummaryDiseasesBreakup() =>
COVID-19:
Total : 8
Cured : 1
Fatality : 0
Active : 7
Spanish Flu:
Total : 2
Cured : 0
Fatality : 0
Active : 2



### Clarifications :- 

If a patient has 2 diseases, COVID and Spanish flu and he/she dies because of COVID, will the fatality be shown in Spanish flu?
⇒ so here if the death reason is COVID19, fatality should be counted only for covid19 , not for Spanish flu, but total active cases will be reduced for both disease


```diff
+ Solution: Code can be found in pandemictracker.zip, written in java.
```

GOD SPEED....

![Alt Text](https://github.com/ravikuril/Machine_coding_FLIPKART/blob/master/gif/space.gif)

