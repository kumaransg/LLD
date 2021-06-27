package exception;

public class CustomerNotFound extends Exception{
    public CustomerNotFound(String customerName) {
        super("Customer with name: "+customerName +" NOT FOUND!");
    }
}
