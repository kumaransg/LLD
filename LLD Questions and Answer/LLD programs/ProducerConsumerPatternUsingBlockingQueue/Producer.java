package ProducerConsumerPatternUsingBlockingQueue;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {

    private final BlockingQueue<Message> sharedQueue;

    public Producer(BlockingQueue<Message> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(new Message(i, "Learning ProducerConsumer"));
            } catch (InterruptedException ex) {
                System.out.println("Error is Producer");
            }
        }
    }

}