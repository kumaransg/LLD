package kafka.publicInterface;

import kafka.handlers.TopicHandler;
import kafka.model.Message;
import kafka.model.Topic;
import kafka.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author priyamvora
 * @created 31/05/2021
 */
public class Kafka {
    Map<String, TopicHandler> topicHandlerMap;

    public Kafka() {
        this.topicHandlerMap = new HashMap<>();
    }

    public void createTopic(String topicName) {
        Topic topic = new Topic(topicName);
        topicHandlerMap.put(topic.getId(), new TopicHandler(topic));
    }

    public void subscribe(Topic topic, ISubscriber subscriber) {
        topic.addSubscriber(new TopicSubscriber(subscriber));
    }

    public void publish(Topic topic, Message message) {
        topic.addMessage(message);
        new Thread(() -> topicHandlerMap.get(topic.getId()).publish()).start();
    }

    public void resetOffSet(Topic topic, ISubscriber subscriber, Integer newOffset) {
        for (TopicSubscriber topicSubscriber : topic.getTopicSubscribers()) {
            if (topicSubscriber.getSubscriber().getId().equals(subscriber.getId())) {
                topicSubscriber.setOffset(new AtomicInteger(newOffset));
                new Thread(() -> topicHandlerMap.get(topic.getId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }

    }

}
