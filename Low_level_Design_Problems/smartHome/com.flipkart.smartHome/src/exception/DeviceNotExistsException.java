package exception;

public class DeviceNotExistsException extends RuntimeException {

    private final String defaultMessage;

    public DeviceNotExistsException(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
