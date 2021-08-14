package customThreadPoolExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author priyamvora
 * @created 29/05/2021
 */
public class CustomThreadPoolExecutor {
    private final List<Runnable> tasksQueue;
    private final Thread[] workerThreads;
    private Integer index;

    public CustomThreadPoolExecutor(Integer poolSize) {
        this.tasksQueue = new ArrayList<>();
        this.workerThreads = new Thread[poolSize];
        this.index = 0;
        startThreads();
    }

    public void startThreads() {
        for (int i = 0; i < workerThreads.length; i++) {
            int finalI = i;
            workerThreads[i] = new Thread(() -> consume(finalI));
            workerThreads[i].start();
        }
    }

    public void execute(Runnable task) {
        synchronized (tasksQueue) {
            System.out.println("Adding task");
            tasksQueue.add(task);
            index++;
            tasksQueue.notifyAll();
        }

    }

    private void consume(Integer threadId) {
        while (true) {
            Runnable task;
            System.out.println("Thread: " + threadId + " is trying to acquire lock");
            synchronized (tasksQueue) {
                System.out.println("Thread: " + threadId + " has acquired lock");
                while (index == 0) {
                    System.out.println("Thread: " + threadId + " is waiting");
                    try {
                        tasksQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                index--;
                System.out.println("Thread: " + threadId + " is consuming task at index: " + index);
                task = tasksQueue.get(index);
            }
            task.run();
        }
    }
}
