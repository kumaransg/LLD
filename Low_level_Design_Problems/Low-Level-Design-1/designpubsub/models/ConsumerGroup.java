/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designpubsub.models;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: ConsumerGroup.java, v 0.1 2021-03-03 1:53 PM paras.chawla Exp $$
 */

// C1 of CG1 and C2 of CG1 can listen same partition of same Topic, This is called as Listening same message by
// different consumers of same topic
public class ConsumerGroup {

    private final String consumerGroupName;
    List<Consumer> consumerList;

    public ConsumerGroup(String consumerGroupName, int numConsumer) {
        this.consumerGroupName = consumerGroupName;
        this.consumerList = new ArrayList<>(numConsumer);
    }

    public void addConsumer(@NonNull final String consumerName) {
        Consumer consumer = new Consumer(consumerName);
        consumerList.add(consumer);
    }

    public void addConsumer(@NonNull final Consumer consumer) {
        consumerList.add(consumer);
    }
}