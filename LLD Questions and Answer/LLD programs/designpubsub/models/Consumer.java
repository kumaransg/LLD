/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designpubsub.models;

import designpubsub.publicInterface.MessageBroker;
import lombok.Getter;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author paras.chawla
 * @version $Id: Consumer.java, v 0.1 2021-03-03 1:53 PM paras.chawla Exp $$
 */

/* 1. Consumer C1 is a part of particular Topic
   2. Consumer is having consumer Name i.e. C1
   3. Every Consumer is part of ConsumerGroup
   4. 1 consumer in a consumer_group is mapped to multiple partitions in a Topic
 */
@Getter
public class Consumer implements Runnable {

    private final AtomicInteger offset;
    private final String        consumerName;
    private final String        consumerId;
    private       String        partitionName;
    private       MessageBroker broker;
    private       String        topicName;

    public Consumer(String consumerName) {
        this.offset = new AtomicInteger(0);
        this.consumerName = consumerName;
        this.consumerId = UUID.randomUUID().toString();
    }

    public void consume(Message message) throws InterruptedException {
        System.out.println("Message Consumed by Consumer:" + consumerName);
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        int currentOffset = this.getOffset().get();

        Message message = broker.consume(topicName, partitionName, this);
        System.out.println("Message consumed successfully");

        // We cannot just increment here since subscriber offset can be reset while it is consuming. So, after
        // consuming we need to increase only if it was previous one.
        if (message != null) {
            this.getOffset().compareAndSet(currentOffset, currentOffset + 1);
        }
    }
}