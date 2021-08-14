package com.flipkart.messaging;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: anirudha
 * Date: 4/21/13
 * Time: 9:58 PM
 *
 * @author anirudha
 */
public class Broker implements Runnable {

    private Map<Topic, List<Consumer>> subscriptionMap = new ConcurrentHashMap<Topic, List<Consumer>>(); // for thread safety
    private Map<Consumer, Message> lastConsumedMessageMap = new ConcurrentHashMap<Consumer, Message>(); // for thread safety
    private Map<Topic, Dispatcher> dispatcherMap = new ConcurrentHashMap<Topic, Dispatcher>();
    private final FilePersistentStore store;
    private final AtomicLong messageCounter = new AtomicLong(100L);

    public Broker(String storeDir) throws FilePersistentStore.FilePersistentStoreException {
        this.store = new FilePersistentStore(storeDir);
    }


    public void publish(Topic topic, String message) throws BrokerException, FilePersistentStore.FilePersistentStoreException {
        Message msg = new Message(topic, message, System.currentTimeMillis(), messageCounter.getAndIncrement());
        this.store.write(topic, msg);
        /*if (dispatcherMap.containsKey(topic)) {

        }*/
    }

    public void subscribe(Consumer consumer, Topic topic) throws BrokerException {
        if (!subscriptionMap.containsKey(topic)) {
            subscriptionMap.put(topic, new CopyOnWriteArrayList<Consumer>());
        }
        subscriptionMap.get(topic).add(consumer);
        lastConsumedMessageMap.put(consumer, null);
    }

    /**
     * the method that loops over the Broker's internal Topic to List of Consumers structure to
     * find the next message to send for that Topic
     * This method does not actually send but instead it is responsible for creating the tasks that will send the message
     */
    public void run() {
        while (true) {
            for (Map.Entry<Topic, List<Consumer>> entry : this.subscriptionMap.entrySet()) {
                Topic topic = entry.getKey();
                List<Consumer> consumers = entry.getValue();
                for (Consumer consumer : consumers) {
                    try {
                        List<Message> messages = store.getNextMessage(topic, this.lastConsumedMessageMap.get(consumer));
                        dispatchMessages(consumer, messages);
                    } catch (IOException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        }

    }

    protected Message dispatchMessages(Consumer consumer, List<Message> messages) {
        int idx = 0;
        for (Message msg : messages) {
            try {
                consumer.consumeMessage(msg);
                idx++;
            } catch (Throwable t) {
                break;
            }
        }
        return messages.get(idx - 1);
    }




}
