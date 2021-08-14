package com.flipkart.messaging;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anirudha
 * Date: 4/21/13
 * Time: 9:59 PM
 *
 * @author anirudha
 */
public class Consumer {

    private final List<Message> messages = new ArrayList<Message>();

    private final Broker broker;

    public Consumer(Broker broker) {
        this.broker = broker;
    }


    public void subscribe(String topicStr) throws BrokerException {
        Topic topic = new Topic(topicStr);
        broker.subscribe(this, topic);
    }

    public void consumeMessage(Message message) {
        this.messages.add(message);
    }

    public List<Message> getMessages() {
        return this.messages;
    }
}
