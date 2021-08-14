package customThreadPoolExecutor;

import java.util.concurrent.TimeUnit;

/**
 * @author priyamvora
 * @created 29/05/2021
 */


class Task implements Runnable {
    private final String print;

    public Task(String print) {
        this.print = print;
    }

    @Override
    public void run() {
        System.out.println(print);
        try {
            System.out.println("Wait started");
            Thread.sleep(10000);
            System.out.println("Wait end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
//        CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor(2);
//        customThreadPoolExecutor.execute(new Task("here1"));
//        customThreadPoolExecutor.execute(new Task("here2"));
//        customThreadPoolExecutor.execute(new Task("here3"));
//        customThreadPoolExecutor.execute(new Task("here4"));
//        customThreadPoolExecutor.execute(new Task("here5"));
//        customThreadPoolExecutor.execute(new Task("here6"));
//

        ScheduledExecutorService scheduledExecutorService = new ScheduledExecutorService(2);
//        scheduledExecutorService.schedule(new Task("here0s delay"), 0, TimeUnit.SECONDS);
//        scheduledExecutorService.schedule(new Task("here10s delay"), 10, TimeUnit.SECONDS);
     scheduledExecutorService.scheduleAtFixedRate(new Task("here10s repeat 0 sec delay"), 0, 10, TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleAtFixedRate(new Task("here10s repeat 5 sec delay"), 5, 10, TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleWithFixedDelay(new Task("here10s delay 0 sec initdelay"), 0, 10, TimeUnit.SECONDS);


    }
}
