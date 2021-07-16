package SystemDesign.VendingMachine;

import java.time.LocalDateTime;
import java.util.HashMap;

public class LoggingServiceImpl implements LoggingService {
    HashMap<Integer,LocalDateTime> hm;

    public LoggingServiceImpl() {
        this.hm = new HashMap<>();
    }

    @Override
    public void logPurchase(Item item, LocalDateTime localDateTime) {
        hm.put(item.id,localDateTime);
    }
}
