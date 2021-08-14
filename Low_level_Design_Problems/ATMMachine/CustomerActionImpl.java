/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package ATMMachine;

public class CustomerActionImpl implements CustomerAction {

    ATMService atmService;

    public CustomerActionImpl(ATMService atmService) {
        this.atmService = atmService;
    }

    public Boolean depostCash(Double amount, String accountId) {
        return atmService.depositCash(amount, accountId);
    }

    public Boolean depostCheck(Check check) {
        return null;
    }


    public Double withdrawCash(Double amount, String accountId) throws InSufficientFundException {
        return null;
    }


    public Double balanceEnquiry(String accountNumber) {
        return null;
    }
}
