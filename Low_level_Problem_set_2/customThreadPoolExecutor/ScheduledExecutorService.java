package customThreadPoolExecutor;

import customThreadPoolExecutor.constants.ScheduledTaskType;
import customThreadPoolExecutor.model.ScheduledTask;

import java.util.concurrent.TimeUnit;

/**
 * @author priyamvora
 * @created 29/05/2021
 */
public class ScheduledExecutorService {
    private final ScheduledExecutorQueue scheduledExecutorQueue;

    public ScheduledExecutorService(int poolSize) {
        this.scheduledExecutorQueue = new ScheduledExecutorQueue(poolSize);
    }

    /**
     * Creates and executes a one-shot action that becomes enabled after the given delay.
     */
    public void schedule(Runnable command, long delay, TimeUnit unit) {
        Long currentTimeMillis = System.currentTimeMillis();
        Long delayInMillis = unit.toMillis(delay);
        scheduledExecutorQueue.addScheduledTask(new ScheduledTask(command, currentTimeMillis + delayInMillis, ScheduledTaskType.ONE_SHOT));
    }

    /**
     * Creates and executes a periodic action that becomes enabled first after the given initial delay, and
     * subsequently with the given period; that is executions will commence after initialDelay then
     * initialDelay+period, then initialDelay + 2 * period, and so on.
     */
    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        Long currentTimeMillis = System.currentTimeMillis();
        Long delayInMillis = unit.toMillis(initialDelay);
        scheduledExecutorQueue.addScheduledTask(new ScheduledTask(command, currentTimeMillis + delayInMillis, ScheduledTaskType.FIXED_RATE, unit.toMillis(period)));
    }

    /*
     * Creates and executes a periodic action that becomes enabled first after the given initial delay, and
     * subsequently with the given delay between the termination of one execution and the commencement of the next.
     */
    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        Long currentTimeMillis = System.currentTimeMillis();
        Long delayInMillis = unit.toMillis(initialDelay);
        scheduledExecutorQueue.addScheduledTask(new ScheduledTask(command, currentTimeMillis + delayInMillis, ScheduledTaskType.FIXED_DELAY, unit.toMillis(delay)));
    }
}
