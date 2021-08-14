# flipkart-interview-parser
A CSV parser for Flipkart machine coding rounds. Created after interviewing with Flipkart :)

Most of the time, the input is very lengthy and difficult to inject using main driver function.
It's much easier and faster to create the input as a csv file and read it rather than using a driver function.
## Example
### Create CSV :-
input.csv
```
id,name,age,salary
1,john,24,2000000
2,jack,22,1400000
3,mary,23,1400000
4,tom,27,2200000
```
### Create your bean class :-
```java
public class Person {
    @CsvBindByName(column = "id")
    private int id;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "age")
    private int age;

    @CsvBindByName(column = "salary")
    private double salary;

    @Override
    public String toString() {
        return "" + id + " " + name + " " + age + " " + salary;
    }
}
```
### Parse CSV to list of beans :-
```java
new ParserForFlipkart<Person>(Person.class, "input.csv").parse();
```
