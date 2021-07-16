/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designpubsub.models;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

/**
 * @author paras.chawla
 * @version $Id: Topic.java, v 0.1 2021-03-02 9:54 AM paras.chawla Exp $$
 */
@Getter
public class Topic {

    String         topicName;
    String         topicId;
    HashSet<Partition> partitions;

    public Topic(String topicName) {
        this.topicName = topicName;
        this.topicId = UUID.randomUUID().toString();
        this.partitions = new HashSet<>();
    }

    // 1. Add Partitions in a Topic
    public Partition addPartion(@NonNull String partitionName){
        Partition partition = new Partition(partitionName);
        this.partitions.add(partition);
        return partition;
    }

    // 2. Add Partitions in a Topic
    public Partition addPartionWithPartitionKey(@NonNull String partitionName,@NonNull String partitionKey){
        Partition partition = new Partition(partitionName,partitionKey);
        this.partitions.add(partition);
        return partition;
    }

    public Partition findPartitionByName(String partionName){
        Iterator<Partition> partitionIterator = partitions.iterator();

        while(partitionIterator.hasNext()){
            Partition partition = partitionIterator.next();
            if(partition.getPartitionName().equals(partionName)){
                return  partition;
            }
        }
        return null;
    }

}