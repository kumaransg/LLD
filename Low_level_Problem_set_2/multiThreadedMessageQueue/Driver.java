package multiThreadedMessageQueue;

import multiThreadedMessageQueue.model.Topic;
import multiThreadedMessageQueue.publicInterface.ISubscriber;
import multiThreadedMessageQueue.publicInterface.Queue;

/**
 * @author priyamvora
 * @created 29/05/2021
 */
public class Driver {
    public static void main(String[] args) throws InterruptedException {
        Queue queue = new Queue();
       Topic topic1 = queue.createTopic("topic1");
       Topic topic2 = queue.createTopic("topic2");

        ISubscriber subscriber1 = new SleepingSubscriber("sub1");
        ISubscriber subscriber2 = new SleepingSubscriber("sub2");
        ISubscriber subscriber3 = new SleepingSubscriber("sub3");

        queue.subscribe(subscriber1,  topic1);
        queue.subscribe(subscriber2,  topic1);

        queue.subscribe(subscriber3,  topic2);

        queue.publish("m1", topic1);
        queue.publish("m2", topic1);
        queue.publish("m3", topic2);

        Thread.sleep(15000);
        queue.resetOffset(topic1, subscriber1, 0);
    }
}
