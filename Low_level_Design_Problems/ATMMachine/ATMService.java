/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package ATMMachine;

import java.util.HashMap;
import java.util.Map;

public class ATMService {

    // Account Number of CustomerAccount Mapping
    private Map<String, CustomerAccount> customerAccountMap = new HashMap<String, CustomerAccount>();

    public CustomerAccount getCustomerAccountByAccountId(String accountId){

        CustomerAccount customer = customerAccountMap.getOrDefault(accountId, null);
        if(customer!=null)
        {
            return customer;
        }
        else{
            throw new CustomerDoesNotExist("Customer account does not exist!");
        }
    }

    public Boolean depositCash(Double amount, String  accountId) {
        CustomerAccount customer = getCustomerAccountByAccountId(accountId);
        customer.depositAmount(amount);
        return true;
    }
}
