package kafka.handlers;

import kafka.model.Topic;
import kafka.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author priyamvora
 * @created 31/05/2021
 */
public class TopicHandler {
    private final Topic topic;
    private final Map<String, SubscriberWorker> subscriberWorkerMap;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        this.subscriberWorkerMap = new HashMap<>();
    }

    public void publish() {
        for (TopicSubscriber topicSubscriber : topic.getTopicSubscribers()) {
            startSubscriberWorker(topicSubscriber);
        }
    }

    public void startSubscriberWorker(TopicSubscriber topicSubscriber) {
        if (!subscriberWorkerMap.containsKey(topicSubscriber.getSubscriber().getId())) {
            SubscriberWorker subscriberWorker = new SubscriberWorker(topicSubscriber, topic);
            subscriberWorkerMap.put(topicSubscriber.getSubscriber().getId(), subscriberWorker);
            new Thread(subscriberWorker).start();
        }
        subscriberWorkerMap.get(topicSubscriber.getSubscriber().getId()).wakeUpIfNeeded();
    }

}
