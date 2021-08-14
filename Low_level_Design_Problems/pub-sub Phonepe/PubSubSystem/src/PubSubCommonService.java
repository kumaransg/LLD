public interface PubSubCommonService {
    boolean addToMessageQueue(Message message);
    void addSubscriber(String regex, Consumer consumer);
    void removeSubscriber(String regex, Consumer consumer);
    void downloadMessages(Consumer consumer);
}
