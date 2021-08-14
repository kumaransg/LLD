package com.flipkart.messaging;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: anirudha
 * Date: 4/21/13
 * Time: 10:37 PM
 *
 * @author anirudha
 */
public class Dispatcher implements Runnable {

    private final BlockingQueue<DispatchTask> taskQueue = new LinkedBlockingQueue<DispatchTask>();
    private final AtomicLong msgs_sent = new AtomicLong(0L);


    public void addDispatchTask(DispatchTask task) {
        taskQueue.offer(task);
    }

    /**
     *
     * @return the number of messages that were dispatched
     * @throws Exception
     */
    @Override
    public void run() {
        while(true) {
            try {
                DispatchTask task = this.taskQueue.take();
                Consumer consumer = task.getConsumer();
                consumer.consumeMessage(task.getMessage());
                msgs_sent.incrementAndGet();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
