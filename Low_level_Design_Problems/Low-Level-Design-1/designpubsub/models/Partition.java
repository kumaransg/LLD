/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designpubsub.models;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author paras.chawla
 * @version $Id: Partition.java, v 0.1 2021-03-03 1:52 PM paras.chawla Exp $$
 */

// Every Partition keeps a map of all consumers who're listening from it.
@Getter
public class Partition {

    private final String        partitionName;
    private final List<Message> messageList;
    private final String        partitionId;
    private final String        partitionKey;
    private final List<Consumer> consumerList;// List<CG> --CG1->C1, CG2->C2 -> C1/C2 parallely execute

    public Partition(@NonNull final String partitionName) {
        this.partitionName = partitionName;
        this.messageList = new ArrayList<>();
        this.partitionId = UUID.randomUUID().toString();
        this.partitionKey=null;
        this.consumerList = new ArrayList<>();
    }

    public Partition(@NonNull final String partitionName,@NonNull final String partitionKey) {
        this.partitionName = partitionName;
        this.messageList = new ArrayList<>();
        this.partitionId = UUID.randomUUID().toString();
        this.partitionKey = partitionKey;
        this.consumerList = new ArrayList<>();
    }

    public void addMessage(@NonNull final Message message){
        this.messageList.add(message);
    }

    public void subscribe(@NonNull final Consumer consumer){
        consumerList.add(consumer);
    }
}