package exception;

import model.User;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(User user){
        super("User: "+ user +" not Found");
    }

}
