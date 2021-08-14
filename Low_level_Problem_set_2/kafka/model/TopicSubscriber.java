package kafka.model;

import kafka.publicInterface.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author priyamvora
 * @created 31/05/2021
 */
public class TopicSubscriber {
    private final ISubscriber subscriber;
    private AtomicInteger offset;

    public TopicSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public void setOffset(AtomicInteger offset) {
        this.offset = offset;
    }
}
