package ProducerConsumerPatternUsingBlockingQueue;

import java.util.concurrent.BlockingQueue;

//Consumer Class in Java
class Consumer implements Runnable{

    private final BlockingQueue<Message> sharedQueue;

    public Consumer (BlockingQueue<Message>sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run()
    {
        while(true){
            try {
                System.out.println(Thread.currentThread().getName() + " consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
                System.out.println(Thread.currentThread().getName() + " Error is Consumer");
            }

            if(sharedQueue.isEmpty())
                break;
        }
    }
}
