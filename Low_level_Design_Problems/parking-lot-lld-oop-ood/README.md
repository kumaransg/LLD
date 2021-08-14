# PROBLEM STATEMENT:

**We will focus on the following set of requirements while designing the parking lot:**

1. The parking lot should have multiple floors where customers can park their cars - **Done**

2. The parking lot should have multiple entry and exit points - **Done**

3. Customers can collect a parking ticket from the entry points and can pay the parking fee at the exit points on their way out - **Done**

4. The system should not allow more vehicles than the maximum capacity of the parking lot. If the parking is full, the system should be able to show a message at the entrance panel and on the parking display board on the ground floor - **Done**

5. Each parking floor will have many parking spots. The system should support multiple types of parking spots such as Small, Medium, Large etc - **Done**

6. Each parking floor should have a display board showing any free parking spot for each spot type - **Done**

7. Customers can pay the tickets at the automated exit panel or to the parking attendant. - **TODO**

8. Customers can pay via both cash and credit cards. - **TODO**

9. The Parking lot should have some parking spots specified for electric cars. These spots should have an electric panel through which customers can pay and charge their vehicles. - **TODO**

10. Customers should also be able to pay the parking fee at the customer’s info portal on each floor. If the customer has paid at the info portal, they don’t have to pay at the exit. - **TODO**

11. The system should support a per-hour parking fee model. For example, customers have to pay $4 for the first hour, $3.5 for the second and third hours, and $2.5 for all the remaining hours. - **TODO**

**PS - This project also containes some TODO. You can be my guest and can raise a PR with these TODO implemented :P**


# What the company is looking for or what are the company's expectations?

They are looking for people who can write code that has flexibility built-in, by adhering to the principles of Object-Oriented Development, and have the ability to deal with the real-life constraints/trade-offs while designing a system.

It is important to note that they are not looking for a GUI and they are not assessing you on the capabilities around code required to do the I/O. The focus is on the overall design. So, while building a solution, it would be nicer (not mandatory) if the input to the code is provided either via unit tests or a file. Using a command-line (for input) can be tedious and difficult to test, so it is best avoided (again not mandatory). Following is a list of things to keep in mind, before you submit your code for any LLD/OOD/OOPs round:

1. Clear identification of domain entities or classes and their relations with appropriate object modeling using composition.

2. Functionality should not be dumped in a single class, method, or file (don't create God class).

3. Write a clean Code with clear intention so as to have good readability (Proper Naming Conventions, Self-documenting code, Avoid redundant commenting, etc).

3. Clear and logical separation of responsibilities with proper boundaries (emphasis on single responsibility (SRP) for high cohesion).

4. Have you applied the principles of YAGNI and KISS?

5. Have you applied SOLID principles to your code?

6. Is the behavior of an object distinguished from its state and is the state encapsulated? 

7. Have you looked at basic refactoring to improve the design of your code?

8. Are the principles applied in a pragmatic way.

9. Code should be easily extensible & maintainable

11. Atomicity and Coverage of Unit Tests.

**Simplicity is the strongest trait of a piece of code. However, easily written code may not necessarily be simple code.**


# Why LLD/OOD/OOPs in software engineering interviews?

So main reason behind asking this kind of problems in an interview is to see whether a candidate can do the following:

1. Can a candidate write a working code in a given short span of time? So as to measure his/her delivery capability?

2. Can a candidate write highly readable, maintainable & extensible code? The intention must be clear by reading the code (Check 4 rules of simple design)

3. Can a candidate follow the principle of DRY (Don't Repeat Yourself) and avoid breaking encapsulation by following or Fat model pattern or Domain-Driven Design(DDD)? (Read tell don't ask principle and Law Demeter)

4. Can a candidate achieve the solution with a minimum number of elements using the YAGNI principle (that is without creating unnecessary interfaces etc)?


# Rules they want you to follow:

You should not use any external libraries to solve this problem, but you can use external libraries or tools for building or testing purposes. Specifically, you can use unit-testing libraries or build tools available for your chosen language (e.g., JUnit, Ant, NUnit, Rspec, Rake, etc.).

They assess a number of things including the design aspect of your solution and your object-oriented programming skills. While these are small problems, They expect you to submit what you believe is production-quality code; code that you’d be able to run, maintain and evolve. You don’t need to gold plate your solution, however, we are looking for something more than a bare-bones algorithm.


# Things I tried to follow in this project/repo:

1. Tried to create all the required domain entities/models as per the problem statement.

2. Tried not to break encapsulation by avoiding getters & setters (as much as possible).

3. Tried to have an immutable state with value objects (as much as possible) so as to avoid concurrency issues (Thread safety).

4. Tried to have readable methods & variables naming so as to clear the intention (4 rules of simple design).

5. Tried to have small & logical commits.

6. Tried to avoid code duplication by refactoring/reusing duplicate code (DRY).

7. Didn't make interfaces as per YAGNI principles because for now, I don't feel the need for the same (Yes, I am aware of this principle also - "Program to interfaces rather than concrete implementation").

8. Tried to put some comments so as to make business logic more understandable.

9. Wrote the job on every class so as to clear its use case.


# Things I could have done/improved in this project/repo if given more time :

1. TDD with 100% code coverage.

2. Code duplication can be further reduced to some extent.

3. Level of indentation can be further reduced in some methods by breaking them into smaller methods.

4. Encapsulation of behavior in some classes can be further improved.

5. More mocking and stubbing of test data in unit tests.
