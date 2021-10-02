package basics;

import java.util.Arrays;

public class Introduction {

    public static long add(int start, int end) {
        long counter = 0;
        for (long i = start; i <= end; ++i) counter += i;
        return counter;
    }

    public static void twoThreads() throws InterruptedException {
        long time = System.currentTimeMillis();
        int start1 = 0, end1 = Integer.MAX_VALUE / 2;
        int start2 = Integer.MAX_VALUE / 2 + 1, end2 = Integer.MAX_VALUE;

        final long[] res1 = new long[1];
        final long[] res2 = new long[1];
        Thread t1 = new Thread(() -> {
            res1[0] = add(start1, end1);
        });
        Thread t2 = new Thread(() -> {
            res2[0] = add(start2, end2);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(res1[0] + res2[0]);
        System.out.println("TWO THREADS: " + (System.currentTimeMillis() - time));
    }

    public static void singleThread() {
        long time = System.currentTimeMillis();
        int start = 0, end = Integer.MAX_VALUE;
        long res = add(start, end);
        System.out.println(res);
        System.out.println("SINGLE THREAD: " + (System.currentTimeMillis() - time));
    }

    public static void main(String[] args) throws InterruptedException {
        twoThreads();
        singleThread();
        Arrays.sort(new int[] {});
    }
}
