package SystemDesign.VendingMachine;

public class VendingMachineFactory {

    public VendingMachine defaultCache(){

        return new VendingMachine(new InventoryServiceImpl(), new LoggingServiceImpl(), new MechanicalServiceImpl(), new PaymentServiceImpl());

    }
}
