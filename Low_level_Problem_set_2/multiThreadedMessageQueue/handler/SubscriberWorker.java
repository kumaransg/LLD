package multiThreadedMessageQueue.handler;

import multiThreadedMessageQueue.model.Message;
import multiThreadedMessageQueue.model.Topic;
import multiThreadedMessageQueue.model.TopicSubscriber;

/**
 * @author priyamvora
 * @created 29/05/2021
 */
public class SubscriberWorker implements Runnable {
    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                Integer currentOffset = topicSubscriber.getOffset().get();
                System.out.println("ThreadID - " + Thread.currentThread().getId() + " Subscriber: " + topicSubscriber.getSubscriber().getId() + " offset now: " + currentOffset);
                while (currentOffset >= topic.getMessageList().size()) {
                    try {
                        System.out.println("Subscriber: " + topicSubscriber.getSubscriber().getId() + " Waiting for message");
                        topicSubscriber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Message message = topic.getMessageList().get(currentOffset);
                try {
                    topicSubscriber.getSubscriber().consume(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                topicSubscriber.getOffset().compareAndSet(currentOffset, currentOffset + 1);
            } while (true);
        }
    }

    public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}
