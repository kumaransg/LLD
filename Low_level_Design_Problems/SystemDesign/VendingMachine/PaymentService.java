package SystemDesign.VendingMachine;

import java.math.BigDecimal;

public interface PaymentService {

    BigDecimal makePayment(Payment payment, BigDecimal amountOwned);
}
