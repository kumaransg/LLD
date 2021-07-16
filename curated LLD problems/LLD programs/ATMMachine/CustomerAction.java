package ATMMachine;

public interface CustomerAction {

    public Boolean depostCash(Double amount, String accountId);

    public Boolean depostCheck(Check check);

    public Double withdrawCash(Double amount, String accountId) throws InSufficientFundException;

    public Double balanceEnquiry(String accountNumber);
}
