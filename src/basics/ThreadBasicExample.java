package basics;

public class ThreadBasicExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // code will run in a new thread
                System.out.println("We are in Thread: " + Thread.currentThread().getName());
                System.out.println("Current Thread Priority: " + Thread.currentThread().getPriority());
            }
        });
        thread.setName("New Worker thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("We are in Thread: " + Thread.currentThread().getName() + " Before starting a new thread.");

        // this will instruct the jvm to create a new thread and pass it to the OS
        thread.start();

        System.out.println("We are in Thread: " + Thread.currentThread().getName() + " After starting a new thread.");

        // It will not spin a loop, it instruct the OS to not schedule the current thread until the time passes.
        // During that time this thread does not consume any CPU.
        Thread.sleep(10000);
    }
}
