package SystemDesign.VendingMachine;

import java.math.BigDecimal;

public class PaymentServiceImpl implements PaymentService {
    BigDecimal transactionAmount;

    public PaymentServiceImpl() {
        this.transactionAmount = BigDecimal.ZERO;
    }

    @Override
    public BigDecimal makePayment(Payment payment, BigDecimal amountOwned) {
        BigDecimal sub = payment.getAmount().subtract(amountOwned);
        transactionAmount.add(amountOwned);
        return sub;
    }
}
