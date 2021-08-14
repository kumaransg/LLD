package com.flipkart.messaging;

/**
 * Created with IntelliJ IDEA.
 * User: anirudha
 * Date: 4/21/13
 * Time: 9:58 PM
 *
 * @author anirudha
 */
public class Publisher {

    private final Broker broker;

    public Publisher(Broker broker) {
        this.broker = broker;
    }

    public void sendMessage(String topicStr, String message) throws BrokerException, FilePersistentStore.FilePersistentStoreException {
        Topic topic = new Topic(topicStr);
        broker.publish(topic, message);
    }
}
