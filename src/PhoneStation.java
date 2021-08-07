import java.util.concurrent.ArrayBlockingQueue;

public class PhoneStation extends Thread {
    private static final int PHONE_STATION_QUEUE_SIZE = 10;
    private static final int ADD_NEW_CALL_TIME = 1000;
    public ArrayBlockingQueue<String> callQueue = new ArrayBlockingQueue(PHONE_STATION_QUEUE_SIZE);
    public static int callCount = 0;
    public static int maxCallCount = 20;

    @Override
    public void run() {
        while (callCount < maxCallCount) {
            try {
                Thread.sleep(ADD_NEW_CALL_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            callCount++;
            callQueue.add("Обращение №" + callCount);
            System.out.println("В очередь добавлено обращение №" + callCount);
        }
        System.out.println("На сегодня хватет :((");
        Thread.interrupted();
    }
}
