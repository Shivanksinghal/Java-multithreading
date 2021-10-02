package basics;

public class Deadlock {

    int counter = 0;
    Object lock1 = new Object();
    Object lock2 = new Object();

    void incrementCounter() throws InterruptedException {
        synchronized (lock1) {
            System.out.println("incrementCounter: Acquiring lock 1");
            synchronized (lock2) {
                System.out.println("incrementCounter: Acquiring lock 2");
                counter ++;
            }
        }
    }

    void decrementCounter() throws InterruptedException {
        synchronized (lock2) {
            System.out.println("decrementCounter: Acquiring lock 2");
            synchronized (lock1) {
                System.out.println("decrementCounter: Acquiring lock 1");
                counter --;
            }
        }
    }
    void runTest() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; ++i) {
                try {
                    incrementCounter();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Counter incremented: " + counter);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; ++i) {
                try {
                    decrementCounter();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Counter decremented: " + counter);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new Deadlock().runTest();
    }
}
