import java.util.Random;

public class Operator extends Thread {
    PhoneStation phoneStation;
    private static final int MIN_SOLVING_TIME = 2000;
    private static final int MAX_SOLVING_TIME = 7000;
    private static final int WAITING_FOR_NEW_CALL = 1000;
    private static int resolvedCount = 0;

    public Operator(PhoneStation phoneStation, String name) {
        super(name);
        this.phoneStation = phoneStation;
    }

    @Override
    public void run() {
        int solvingProblemTime = new Random().nextInt(MAX_SOLVING_TIME) + MIN_SOLVING_TIME;
        while (resolvedCount < PhoneStation.maxCallCount) {
            try {
                Thread.sleep(solvingProblemTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!phoneStation.callQueue.isEmpty()) {
                resolvedCount++;
                System.out.println(Thread.currentThread().getName() +
                        " обрабатывает " + phoneStation.callQueue.poll());
                System.out.println("---На очереди: " + phoneStation.callQueue.size() + " обращений---");
            }
            try {
                Thread.sleep(WAITING_FOR_NEW_CALL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " пошёл домой");
        Thread.interrupted();
    }
}
