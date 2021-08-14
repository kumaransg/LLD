import java.util.List;

public interface Consumer {
    void register();
    void deregister();
    List<Message> getMessages();
    String getRegex();
    void addPredecessor(Consumer consumer);
    boolean addMessageToList(Message message);
    void printMessages();
    void getAllMyMessages();
    String getName();
}
