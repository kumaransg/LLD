package lowleveldesign.uber.api.exceptions;

public class NoSuchUserException extends APIException {
    public NoSuchUserException(String errorMessage) {
        super(errorMessage);
    }
}
