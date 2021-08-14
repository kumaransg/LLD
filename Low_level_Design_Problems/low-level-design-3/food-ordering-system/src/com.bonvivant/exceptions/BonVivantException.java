package exceptions;

public class BonVivantException extends Exception{
    private static final long serialVersionUID = 1L;

    public BonVivantException(String message){
        super(message);
    }

    public BonVivantException(String message, Throwable cause) {
        super(message, cause);
    }
}
