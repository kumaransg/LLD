package multiThreadedMessageQueue.publicInterface;

import multiThreadedMessageQueue.handler.TopicHandler;
import multiThreadedMessageQueue.model.Message;
import multiThreadedMessageQueue.model.Topic;
import multiThreadedMessageQueue.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author priyamvora
 * @created 29/05/2021
 */
public class Queue {
    private final Map<String, TopicHandler> topicHandlerMap;

    public Queue() {
        this.topicHandlerMap = new HashMap<>();
    }

    public Topic createTopic(String topicName) {
        Topic topic = new Topic(topicName);
        TopicHandler topicHandler = new TopicHandler(topic);
        System.out.println("Created topic: " + topic.getTopicName());
        topicHandlerMap.put(topic.getTopicId(), topicHandler);
        return topic;
    }

    public void subscribe(ISubscriber subscriber, Topic topic) {
        topic.addSubscriber(new TopicSubscriber(subscriber));
        System.out.println(subscriber.getId() + " subscribed to topic: " + topic.getTopicName());
    }

    public void publish(String message, Topic topic) {
        topic.addMessage(new Message(message));
        new Thread(() -> topicHandlerMap.get(topic.getTopicId()).publish()).start();
    }

    public void resetOffset(Topic topic, ISubscriber subscriber, Integer newOffset) {
        for (TopicSubscriber topicSubscriber : topic.getTopicSubscribers()) {
            if (topicSubscriber.getSubscriber().equals(subscriber)) {
                topicSubscriber.getOffset().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId() + " offset reset to: " + newOffset);
                new Thread(() -> topicHandlerMap.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }

}
