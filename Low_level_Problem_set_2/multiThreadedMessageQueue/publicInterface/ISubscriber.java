package multiThreadedMessageQueue.publicInterface;

import multiThreadedMessageQueue.model.Message;

/**
 * @author priyamvora
 * @created 29/05/2021
 */
public interface ISubscriber {
    String getId();

    void consume(Message message) throws InterruptedException;
}
