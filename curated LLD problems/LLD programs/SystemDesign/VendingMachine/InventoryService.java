package SystemDesign.VendingMachine;

import java.math.BigDecimal;
import java.util.List;

public interface InventoryService {
    List<Location> showItem();
    BigDecimal getSelectedItemPrice(Location location);

    Item getItem(Location itemLocation);
}
