/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designpubsub;

import designpubsub.models.Consumer;
import designpubsub.models.ConsumerGroup;
import designpubsub.models.Message;
import designpubsub.models.Partition;
import designpubsub.models.Topic;
import designpubsub.publicInterface.MessageBroker;

/**
 * @author paras.chawla
 * @version $Id: Main.java, v 0.1 2021-03-04 10:57 AM paras.chawla Exp $$
 */
public class Main {

    public static void main(String[] args) {
        MessageBroker broker = new MessageBroker();

        // 1. Creating a Topic
        Topic topic = broker.createTopic("Topic1");

        // 2. Creating partitions in Topic
        Partition p1= broker.createPartition(topic,"P1");
        Partition p2= broker.createPartition(topic,"P2");
        Partition p3= broker.createPartition(topic,"P3");

        // 3. Create a consumerGroup
        ConsumerGroup consumerGroup= broker.createConsumerGroup("C_G1",3);

        // 4. Create multiple Consumers in a ConsumerGroup
        Consumer c1 = broker.createConsumer("C1",consumerGroup);
        Consumer c2 = broker.createConsumer("C1",consumerGroup);
        Consumer c3 = broker.createConsumer("C1",consumerGroup);

        // 5. Subscribe a consumer_group to a particular topic and partitions
        broker.subscribe(topic,p1,c1);
        broker.subscribe(topic,p2,c2);
        broker.subscribe(topic,p3,c3);

        // 6. publish message
        broker.publish(topic,p1,new Message("Hey"));

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();

    }

}