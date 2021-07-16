package SystemDesign.VendingMachine;

import java.math.BigDecimal;
import java.util.List;

public class MechanicalServiceImpl implements MechanicalService {


    public MechanicalServiceImpl() {

    }

    @Override
    public void takePayment(BigDecimal amountSubmitted) {
        return;
    }

    @Override
    public BigDecimal returnChanges(BigDecimal bigDecimal) {
        return bigDecimal;
    }

    @Override
    public void releaseItem(Item item) {
        return;
    }

    @Override
    public void displayAvailableItems(List<Location> items) {

    }
}
