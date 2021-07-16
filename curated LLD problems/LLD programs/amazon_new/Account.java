package amazon;

import java.util.Date;
import java.util.List;

public class Account {
    int id;
    String username;
    String password;
    Date createdAt;
    String phone;
    String email;
    AccountStatus accountStatus;
    List<Address> shippingAddresses;
    
    public List<Address> getAddress(){
        return shippingAddresses;
    }
    
    public void addAddress(Address address) {
        
    }
}
