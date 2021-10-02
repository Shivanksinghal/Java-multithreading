package basics;

import java.lang.Thread.UncaughtExceptionHandler;

public class UncaughtExceptionExample {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            throw new RuntimeException();
        });

        thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Exception handled");
            }
        });

        thread.start();
    }
}
