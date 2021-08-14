package multiThreadedMessageQueue.model;

/**
 * @author priyamvora
 * @created 29/05/2021
 */
public class Message {
    private final String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }
}
