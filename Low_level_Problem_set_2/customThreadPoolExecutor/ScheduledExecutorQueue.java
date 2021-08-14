package customThreadPoolExecutor;

import customThreadPoolExecutor.constants.ScheduledTaskType;
import customThreadPoolExecutor.model.ScheduledTask;
import kafka.handlers.SubscriberWorker;

import java.util.PriorityQueue;

/**
 * @author priyamvora
 * @created 29/05/2021
 */
public class ScheduledExecutorQueue {
    private final PriorityQueue<ScheduledTask> scheduledTasks;
    private final Thread[] workerThreads;

    public ScheduledExecutorQueue(int poolSize) {
        this.scheduledTasks = new PriorityQueue<>();
        workerThreads = new Thread[poolSize];
        intializeWorkerThreads();
    }

    private void intializeWorkerThreads() {
        for (int i = 0; i < workerThreads.length; i++) {
            workerThreads[i] = new Thread(() -> {
                try {
                    polling();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            workerThreads[i].start();
        }
    }

    public void addScheduledTask(ScheduledTask task) {
        synchronized (scheduledTasks) {
            System.out.println("Add task to queue: " + task);
            scheduledTasks.add(task);
            scheduledTasks.notifyAll();
        }
    }

    private void polling() throws InterruptedException {
        while (true) {
            ScheduledTask taskToExecute = null;
            System.out.println("Thread: " + Thread.currentThread().getId() + " trying to acquire lock");
            synchronized (scheduledTasks) {
                System.out.println("Thread: " + Thread.currentThread().getId() + " acquired lock");
                while (scheduledTasks.isEmpty()) {
                    System.out.println("Thread: " + Thread.currentThread().getId() + " waiting");
                    scheduledTasks.wait();
                }
                ScheduledTask task = scheduledTasks.peek();
                if (task.getScheduledExecutionTime() <= System.currentTimeMillis()) {
                    taskToExecute = scheduledTasks.poll();
                }
                //scheduledTasks.notifyAll();
            }
            if (taskToExecute == null) {
                //   System.out.println("Thread: " + Thread.currentThread().getId() + " going to sleep");
                Thread.sleep(2000);
                continue;
            }
            // For fixed rate add at initialDelay + period, initialDelay + 2*period
            if (taskToExecute != null && taskToExecute.getScheduledTaskType().equals(ScheduledTaskType.FIXED_RATE)) {
                ScheduledTask scheduledTask = cloneScheduledTask(taskToExecute);
                scheduledTask.setScheduledExecutionTime(System.currentTimeMillis() + scheduledTask.getSchedulePeriodInMillis());
                addScheduledTask(scheduledTask);
            }
            System.out.println("Thread: " + Thread.currentThread().getId() + " executing a task");
            taskToExecute.getTask().run();
            // For fixed delay add at currentEndTime + period;
            if (taskToExecute != null && taskToExecute.getScheduledTaskType().equals(ScheduledTaskType.FIXED_DELAY)) {
                ScheduledTask scheduledTask = cloneScheduledTask(taskToExecute);
                scheduledTask.setScheduledExecutionTime(System.currentTimeMillis() + scheduledTask.getSchedulePeriodInMillis());
                addScheduledTask(scheduledTask);
            }
        }

    }

    private ScheduledTask cloneScheduledTask(ScheduledTask scheduledTask) {
        ScheduledTask clone = new ScheduledTask(scheduledTask.getTask(), scheduledTask.getScheduledExecutionTime(), scheduledTask.getScheduledTaskType(), scheduledTask.getSchedulePeriodInMillis());
        return clone;
    }
}
