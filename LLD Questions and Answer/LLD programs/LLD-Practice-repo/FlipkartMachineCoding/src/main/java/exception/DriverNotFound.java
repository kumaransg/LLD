package exception;

public class DriverNotFound extends Exception{
    public DriverNotFound(String driverName) {
        super("Driver with name : "+ driverName+ " NOT FOUND!");
    }
}
