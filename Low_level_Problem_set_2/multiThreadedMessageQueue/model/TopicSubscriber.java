package multiThreadedMessageQueue.model;

import multiThreadedMessageQueue.publicInterface.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author priyamvora
 * @created 29/05/2021
 */
public class TopicSubscriber {
    private final AtomicInteger offset;
    private final ISubscriber subscriber;

    public TopicSubscriber(ISubscriber subscriber) {
        this.offset = new AtomicInteger(0);
        this.subscriber = subscriber;
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }
}
