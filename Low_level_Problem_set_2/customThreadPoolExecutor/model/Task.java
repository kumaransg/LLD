package customThreadPoolExecutor.model;

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