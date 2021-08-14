package SystemDesign.VendingMachine;

import java.math.BigDecimal;
import java.util.List;

public interface MechanicalService {
    void takePayment(BigDecimal bigDecimal);
    BigDecimal returnChanges(BigDecimal bigDecimal);
    void releaseItem(Item item);
    void displayAvailableItems(List<Location> items);

}
