package SystemDesign.LogisticsDesign;

public class PaymentDetails {
    private PaymentMode paymentMode;
    private String transactionId;
    private int amount;
    private PaymentStatus paymentStatus;
    private String cardNumber;

    public PaymentMode getPaymentMode()
    {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode)
    {
        this.paymentMode = paymentMode;
    }

    public String getTransactionId()
    {
        return transactionId;
    }

    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus()
    {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus)
    {
        this.paymentStatus = paymentStatus;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }
}
