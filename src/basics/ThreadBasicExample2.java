package basics;

public class ThreadBasicExample2 {
    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        Thread t = new NewThread();
        t.start();
    }
}
