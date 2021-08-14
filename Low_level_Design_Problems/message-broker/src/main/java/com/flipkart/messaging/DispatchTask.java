package com.flipkart.messaging;

/**
 * Created with IntelliJ IDEA.
 * User: anirudha
 * Date: 4/21/13
 * Time: 10:37 PM
 *
 * @author anirudha
 */
public class DispatchTask {

    private final Consumer consumer;

    public Message getMessage() {
        return message;
    }

    private final Message message;

    public DispatchTask(Consumer consumer, Message message) {
        this.consumer = consumer;
        this.message = message;
    }

    public Consumer getConsumer() {
        return consumer;
    }


}
