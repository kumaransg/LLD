package expense.models;

public class Split {

    private User loaner;
    private User loanee;

    private double amount;

    public Split(User loaner, User loanee, double amount) {
        this.loaner = loaner;
        this.loanee = loanee;
        this.amount = amount;
    }

    public User getLoaner() {
        return loaner;
    }

    public void setLoaner(User loaner) {
        this.loaner = loaner;
    }

    public User getLoanee() {
        return loanee;
    }

    public void setLoanee(User loanee) {
        this.loanee = loanee;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Split{" +
                "loaner=" + loaner +
                ", loanee=" + loanee +
                ", amount=" + amount +
                '}';
    }
}
