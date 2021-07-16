/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designpubsub.publicInterface;

import designpubsub.models.Consumer;
import designpubsub.models.ConsumerGroup;
import designpubsub.models.Message;
import designpubsub.models.Partition;
import designpubsub.models.Topic;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: MessageBroker.java, v 0.1 2021-03-02 10:01 AM paras.chawla Exp $$
 */
public class MessageBroker {

    private final List<Topic> topicsList;

    public MessageBroker() {
        this.topicsList = new ArrayList<>();
    }

    // 1. creating a Topic
    public Topic createTopic(@NonNull final String topicName) {
        Topic topic = new Topic(topicName);
        topicsList.add(topic);
        System.out.println("Created new Topic" + topic.getTopicName());
        return topic;
    }

    // 2. Creating a Partition in a TOPIC
    public Partition createPartition(@NonNull final Topic topic, @NonNull final String partionName) {
        return topic.addPartion(partionName);
    }

    // 3. Publish message
    public void publish(@NonNull Topic topic, @NonNull Partition partition, @NonNull Message message) {

        // 2.1 if partition doesn't exist prior, create partition on the fly
        if (!topic.getPartitions().contains(partition)) {
            topic.addPartion(partition.getPartitionName());
        }
        partition.addMessage(message);
        System.out.println("Message published successfully");

        // 2.2 Find all consumers in different consumer-Group listening to this particular partition
        // Only 1 consumer from 1 consumerGroup can participate in listening from this particular partion

        /* Approach 1- Using stand alone Threads
        for (Consumer consumer : partition.getConsumerList()) {
            // creating a seperate task for seperate Consumer
            ConsumerWorker consumerWorker = new ConsumerWorker(topic, partition, consumer);
            // executing task
            new Thread(consumerWorker).start();
        }


        // Approach 2 - get count of available cores
        int coreCounts = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCounts);
        for (Consumer consumer : partition.getConsumerList()) {// partition -> List<CG> -> List<C> C1,C2,C3
            // creating a seperate task for seperate Consumer
            ConsumerWorker consumerWorker = new ConsumerWorker(topic, partition, consumer);
            service.execute(consumerWorker);
        }
        */
    }
    /*
     * ConsumeRunner -> 3 threads for 3 consumers calling consume api
     * partition.message.size ==0 wait
     *
     * */

    public Message consume(@NonNull String topicName, String partitionName, Consumer consumer) {

        Topic topic = null;
        for (Topic t : this.topicsList) {
            if (t.getTopicName().equals(topicName)) {
                topic = t;
                break;
            }
        }

        Partition partition = topic.findPartitionByName(partitionName);

        return partition.getMessageList().get((consumer.getOffset().get()));
    }

    // 3. Creating a Consumer-Group and give number of consumers as well
    public ConsumerGroup createConsumerGroup(@NonNull final String consumerGroupName, @NonNull final int numConsumers) {
        ConsumerGroup group = new ConsumerGroup(consumerGroupName, numConsumers);
        System.out.println("ConsumerGroup created successfully");
        return group;
    }

    // 4. Creating a Consumer in a consumerGroup
    public Consumer createConsumer(@NonNull String consumerName, @NonNull ConsumerGroup consumerGroup) {
        Consumer consumer = new Consumer(consumerName);
        consumerGroup.addConsumer(consumer);
        System.out.println("New Consumer in ConsumerGroup created successfully");
        return consumer;
    }

    // 5. Subscribe a consumer to a particular topic and a particular partition
    public void subscribe(@NonNull Topic topic, @NonNull Partition partition, @NonNull Consumer consumer) {

        // Only Subscribe if partition exist
        if (topic.getPartitions().contains(partition)) {
            partition.subscribe(consumer);
        }
    }

    // 6. reset offset
    public void resetOffset(@NonNull Topic topic, @NonNull Consumer consumer, @NonNull Integer newOffset) {

    }

}