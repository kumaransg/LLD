package SystemDesign.VendingMachine;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private InventoryService inventoryService;
    private LoggingService loggingService;
    private MechanicalService mechanicalService;
    private PaymentService paymentService;
    private List<Location> itemsLocation;
    private Item selectedItem;
    private BigDecimal amountOwned;

    public VendingMachine(InventoryService inventoryService, LoggingService loggingService, MechanicalService mechanicalService, PaymentService paymentService) {
        this.inventoryService = inventoryService;
        this.loggingService = loggingService;
        this.mechanicalService = mechanicalService;
        this.paymentService = paymentService;
        initVendingMachine();
    }

    private void initVendingMachine(){
        itemsLocation = new ArrayList<>();
        for(int i=0;i<10;i++){
            Location l = new Location(i,i);
            itemsLocation.add(l);
        }
        itemsLocation = inventoryService.showItem();
        mechanicalService.displayAvailableItems(itemsLocation);
        selectedItem = null;
        amountOwned=BigDecimal.ZERO;
    }

    private void SelectItem(Location itemLocation){
        amountOwned = inventoryService.getSelectedItemPrice(itemLocation);
        selectedItem = inventoryService.getItem(itemLocation);
    }

    private void processPurchase(Payment payment){
        BigDecimal returnChange = paymentService.makePayment(payment,amountOwned);
        loggingService.logPurchase(selectedItem, LocalDateTime.now());
        returnChange(returnChange);
        releaseProduct();
        resetSelectedItem();
    }

    private void resetSelectedItem() {
        selectedItem=null;
    }

    private void releaseProduct() {
        mechanicalService.releaseItem(selectedItem);
    }

    private void returnChange(BigDecimal changes) {
        mechanicalService.returnChanges(changes);
    }

}
