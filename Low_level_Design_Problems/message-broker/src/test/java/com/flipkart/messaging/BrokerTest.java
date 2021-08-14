package com.flipkart.messaging;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: anirudha
 * Date: 4/21/13
 * Time: 11:37 PM
 *
 * @author anirudha
 */
public class BrokerTest {

    @Test
    public void testBroker() throws Exception {

        Broker broker = new Broker("/tmp");
        Publisher publisher = new Publisher(broker);
        Consumer consumer = new Consumer(broker);

        publisher.sendMessage("testTopic", "this is a test message");
        consumer.subscribe("testTopic");
        broker.run();

        List<Message> messageList = consumer.getMessages();

        assertEquals(messageList.size(), 1);
    }
}
