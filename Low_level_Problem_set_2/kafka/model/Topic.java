package kafka.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author priyamvora
 * @created 31/05/2021
 */
public class Topic {
    private final String id;
    private final String name;
    private final List<Message> messageList;
    private final List<TopicSubscriber> topicSubscribers;

    public Topic(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.messageList = new ArrayList<>();
        this.topicSubscribers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void addMessage(Message message) {
        messageList.add(message);
    }

    public void addSubscriber(TopicSubscriber topicSubscriber) {
        topicSubscribers.add(topicSubscriber);
    }

    public List<TopicSubscriber> getTopicSubscribers() {
        return topicSubscribers;
    }
}
