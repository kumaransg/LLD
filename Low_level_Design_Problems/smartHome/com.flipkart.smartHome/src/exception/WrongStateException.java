package exception;

public class WrongStateException extends RuntimeException  {

    private final String defaultMessage;

    public WrongStateException(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
