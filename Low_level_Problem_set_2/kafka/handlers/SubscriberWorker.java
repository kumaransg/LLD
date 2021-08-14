package kafka.handlers;

import kafka.model.Topic;
import kafka.model.TopicSubscriber;

/**
 * @author priyamvora
 * @created 31/05/2021
 */
public class SubscriberWorker implements Runnable {
    private final TopicSubscriber topicSubscriber;
    private final Topic topic;

    public SubscriberWorker(TopicSubscriber topicSubscriber, Topic topic) {
        this.topicSubscriber = topicSubscriber;
        this.topic = topic;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (topicSubscriber) {
                int currOffset = topicSubscriber.getOffset().intValue();
                while (currOffset >= topic.getMessageList().size()) {
                    try {
                        topicSubscriber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                topicSubscriber.getSubscriber().consume(topic.getMessageList().get(currOffset));
                topicSubscriber.getOffset().compareAndSet(currOffset, currOffset + 1);
            }
        }
    }

    public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}
