package SystemDesign.VendingMachine;

import java.time.LocalDateTime;

public interface LoggingService {

    void logPurchase(Item item, LocalDateTime localDateTime);
}
