package multiThreadedMessageQueue;

import multiThreadedMessageQueue.model.Message;
import multiThreadedMessageQueue.publicInterface.ISubscriber;

/**
 * @author priyamvora
 * @created 29/05/2021
 */
public class SleepingSubscriber implements ISubscriber {
    private final String id;

    public SleepingSubscriber(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("subscriber: " + id + " started consuming message: " + message);
        Thread.sleep(10000);
        System.out.println("subscriber: " + id + " done consuming message: " + message);
    }
}
