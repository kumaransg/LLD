import java.math.BigDecimal;

public class Transaction {
    private final Double id;
    private final PaymemtMode mode;
    private BigDecimal amountPaid;

    public Transaction(PaymemtMode mode, BigDecimal amountPaid) {
        this.id = Math.random();
        this.mode = mode;
        this.amountPaid = amountPaid;
    }
}