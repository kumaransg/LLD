package multiThreadedMessageQueue.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author priyamvora
 * @created 29/05/2021
 */
public class Topic {
    private final String topicId;
    private final String topicName;
    private final List<Message> messageList;
    private final List<TopicSubscriber> topicSubscribers;

    public Topic(String topicName) {
        this.topicId = UUID.randomUUID().toString();
        this.topicName = topicName;
        this.messageList = new ArrayList<>();
        this.topicSubscribers = new ArrayList<>();
    }

    public String getTopicId() {
        return topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public List<TopicSubscriber> getTopicSubscribers() {
        return topicSubscribers;
    }

    public void addMessage(Message message){
        messageList.add(message);
    }

    public void addSubscriber(TopicSubscriber topicSubscriber){
        topicSubscribers.add(topicSubscriber);
    }
}
