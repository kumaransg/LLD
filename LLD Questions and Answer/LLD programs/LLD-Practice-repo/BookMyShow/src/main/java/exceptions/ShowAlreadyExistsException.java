package exceptions;

import model.Show;

public class ShowAlreadyExistsException extends Exception{
    public ShowAlreadyExistsException(Long id){
        super("Show with id: "+id+" already Exists.");
    }
}
