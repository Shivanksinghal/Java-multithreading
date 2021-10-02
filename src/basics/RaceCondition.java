package basics;

import java.util.Random;

class Demonstration {

    public static void main(String[] args) throws InterruptedException {
        RaceCondition.runTest();
    }
}

public class RaceCondition {
    int randInt;
    Random random = new Random(System.currentTimeMillis());

    void printer() {
        int i = 1000000;
        while(i != 0) {
            synchronized (this) {
                if (randInt % 5 == 0) {
                    if (randInt % 5 != 0) {
                        System.out.println(randInt);
                    }
                }
            }
            i --;
        }
    }

    void modifier() {
        int i = 1000000;
        while (i != 0) {
            synchronized (this) {
                i--;
                randInt = random.nextInt(1000);
            }
        }
    }
    public static void runTest() throws InterruptedException {
        RaceCondition raceCondition = new RaceCondition();
        Thread t1 = new Thread(() -> {
            raceCondition.printer();
        });

        Thread t2 = new Thread(() -> {
            raceCondition.modifier();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}


