
package ProducerConsumerPatternUsingBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//Producer Class in java
public class MainDriver {

    public static void main(String args[]){
  
        int queueSize=10;
     //Creating shared object
     BlockingQueue<Message> sharedQueue = new ArrayBlockingQueue<Message>(queueSize);
 
     //Creating Producer and Consumer Thread
     Thread prodThread = new Thread(new Producer(sharedQueue));
     Thread consThread = new Thread(new Consumer(sharedQueue));
     Thread consThread2 = new Thread(new Consumer(sharedQueue));

     consThread.setName("Consumer thread 1");
     consThread2.setName("Consumer thread 2");

     //Starting producer and Consumer thread
     prodThread.start();
     consThread.start();
     consThread2.start();
    }
 
}
//You see Producer Thread  produced number and Consumer thread consumes it
//in FIFO order because blocking queue allows elements to be accessed in FIFO.


