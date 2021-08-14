package SystemDesign.VendingMachine;

public class Driver {
    public static void main(String[] args){
        VendingMachineFactory vendingMachineFactory = new VendingMachineFactory();
        VendingMachine vm = vendingMachineFactory.defaultCache();

    }
}
