import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class CustomSchedulerService {

    private final PriorityQueue<ScheduledTask> taskQueue;
    private final Lock lock = new ReentrantLock();
    private final Condition newTaskAdded = lock.newCondition();
    private final ThreadPoolExecutor workerExecutor;

    public CustomSchedulerService(int workerThreadSize) {
        this.taskQueue = new PriorityQueue<>(Comparator.comparingLong(ScheduledTask::getScheduledTime));
        workerExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(workerThreadSize);
    }

    public void start() {
        long timeToSleep = 0;
        while (true) {
            lock.lock();
            try {
                while (taskQueue.isEmpty()) {
                    newTaskAdded.await();
                }
                while (!taskQueue.isEmpty()) {
                    timeToSleep = taskQueue.peek().getScheduledTime() - System.currentTimeMillis();
                    if (timeToSleep <= 0) {
                        break;
                    }
                    newTaskAdded.await(timeToSleep, TimeUnit.MILLISECONDS);
                }
                ScheduledTask task = taskQueue.poll();
                long newScheduledTime = 0;
                switch (task.getTaskType()) {
                case 1:
                    //this type of task will be executed only once
                    workerExecutor.submit(task.getRunnable());
                    break;
                case 2:
                    newScheduledTime = System.currentTimeMillis() + task.getUnit().toMillis(task.getPeriod());
                    workerExecutor.submit(task.getRunnable());
                    task.setScheduledTime(newScheduledTime);
                    taskQueue.add(task);
                    break;
                case 3:
                    Future<?> future = workerExecutor.submit(task.getRunnable());
                    future.get(); // will wait for the finish of this task
                    newScheduledTime = System.currentTimeMillis() + task.getUnit().toMillis(task.getDelay());
                    task.setScheduledTime(newScheduledTime);
                    taskQueue.add(task);
                    break;
                }
            } catch (Exception e) {
                System.out.println("some thing wrong in start");
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    /**
     * Creates and executes a one-shot action that becomes enabled after the given delay.
     */
    public void schedule(Runnable command, long delay, TimeUnit unit) {
        lock.lock();
        try {
            long scheduledTime = System.currentTimeMillis() + unit.toMillis(delay);
            ScheduledTask task = new ScheduledTask(command, scheduledTime, 1, null, null, unit);
            taskQueue.add(task);
            newTaskAdded.signalAll();
        } catch (Exception e) {
            System.out.println("some thing wrong in scheduling task type 1");
        } finally {
            lock.unlock();
        }
    }

    /**
     * Creates and executes a periodic action that becomes enabled first after the given initial delay, and
     * subsequently with the given period; that is executions will commence after initialDelay then
     * initialDelay+period, then initialDelay + 2 * period, and so on.
     */
    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        lock.lock();
        try {
            long scheduledTime = System.currentTimeMillis() + unit.toMillis(initialDelay);
            ScheduledTask task = new ScheduledTask(command, scheduledTime, 2, period, null, unit);
            taskQueue.add(task);
            newTaskAdded.signalAll();
        } catch (Exception e) {
            System.out.println("some thing wrong in scheduling task type 2");
        } finally {
            lock.unlock();
        }
    }

    /*
     * Creates and executes a periodic action that becomes enabled first after the given initial delay, and
     * subsequently with the given delay between the termination of one execution and the commencement of the next.
     */
    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        lock.lock();
        try {
            long scheduledTime = System.currentTimeMillis() + unit.toMillis(initialDelay);
            ScheduledTask task = new ScheduledTask(command, scheduledTime, 3, null, delay, unit);
            taskQueue.add(task);
            newTaskAdded.signalAll();
//            throw new UnabletoSchedule("some thing wrong in scheduling task type 3");
        } catch (Exception e) {
//            System.out.println("some thing wrong in scheduling task type 3");
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static Runnable getRunnableTask(String s) {
        return () -> {
            System.out.println(s + " started at " + System.currentTimeMillis() / 1000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s + " ended at " + System.currentTimeMillis() / 1000);
        };
    }


    public static void main(String[] args) {
        CustomSchedulerService schedulerService = new CustomSchedulerService(10);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute();
        Runnable task1 = getRunnableTask("Task1");
        schedulerService.schedule(task1, 1, TimeUnit.SECONDS);
        Runnable task2 = getRunnableTask("Task2");
        schedulerService.scheduleAtFixedRate(task2, 1, 2, TimeUnit.SECONDS);
        Runnable task3 = getRunnableTask("Task3");
        schedulerService.scheduleWithFixedDelay(task3, 1, 2, TimeUnit.SECONDS);
        Runnable task4 = getRunnableTask("Task4");
        schedulerService.scheduleAtFixedRate(task4, 1, 2, TimeUnit.SECONDS);
        schedulerService.start();
    }
}
