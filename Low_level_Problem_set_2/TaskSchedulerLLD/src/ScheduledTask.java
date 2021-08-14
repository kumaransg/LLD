import java.util.concurrent.TimeUnit;

class ScheduledTask {
    private final Runnable runnable;
    private Long scheduledTime;
    private final int taskType;
    private final Long period;
    private final Long delay;
    private final TimeUnit unit;

    public ScheduledTask(Runnable runnable, Long scheduledTime, int taskType, Long period, Long delay, TimeUnit unit) {
        this.runnable = runnable;
        this.scheduledTime = scheduledTime;
        this.taskType = taskType;
        this.period = period;
        this.delay = delay;
        this.unit = unit;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public Long getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Long scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public int getTaskType() {
        return taskType;
    }

    public Long getPeriod() {
        return period;
    }

    public Long getDelay() {
        return delay;
    }

    public TimeUnit getUnit() {
        return unit;
    }
}
