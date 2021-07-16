/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designpubsub.handlers;

import designpubsub.models.Consumer;
import designpubsub.models.Message;
import designpubsub.models.Partition;
import designpubsub.models.Topic;
import lombok.NonNull;
import lombok.SneakyThrows;

/**
 * @author paras.chawla
 * @version $Id: ConsumerWorker.java, v 0.1 2021-03-03 5:23 PM paras.chawla Exp $$
 */
public class ConsumerWorker implements Runnable {

    private final Topic     topic;
    private final Partition partition;
    private final Consumer  consumer;

    public ConsumerWorker(@NonNull final Topic topic, @NonNull final Partition partition, @NonNull final Consumer consumer) {
        this.topic = topic;
        this.partition = partition;
        this.consumer = consumer;
    }

    @Override
    @SneakyThrows
    public void run() {// C1 || C2 || C3
        synchronized (consumer) {
            do {

                int currentOffset = consumer.getOffset().get();
                while (currentOffset >= partition.getMessageList().size()) {
                    consumer.wait();
                }

                Message message = partition.getMessageList().get(currentOffset);
                consumer.consume(message);

                // We cannot just increment here since subscriber offset can be reset while it is consuming. So, after
                // consuming we need to increase only if it was previous one.
                consumer.getOffset().compareAndSet(currentOffset, currentOffset + 1);
            } while (true);
        }
    }

    synchronized public void wakeUpIfNeeded() {
        synchronized (consumer) {
            consumer.notify();
        }
    }
}