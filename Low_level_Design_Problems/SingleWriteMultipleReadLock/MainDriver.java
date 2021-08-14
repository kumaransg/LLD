package SingleWriteMultipleReadLock;

public class MainDriver {
    public static void main(String[] args) {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();


        Thread writeThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                concurrentHashMap.put("Nikhil", "Agrawal");
            }

        });

        Thread writeThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                concurrentHashMap.put("Nikhil", "Agrawal1");
            }

        });


        Thread readThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println(concurrentHashMap.get("Nikhil"));
            }

        });
        Thread readThread2 = new Thread(new Runnable () {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println(concurrentHashMap.get("Nikhil"));
            }
        });


        writeThread1.start();
        writeThread2.start();

        readThread1.start();
        readThread2.start();
    }
}
