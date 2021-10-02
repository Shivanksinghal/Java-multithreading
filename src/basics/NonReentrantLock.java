package basics;

class NonReentrantLock {

    boolean isLocked;

    public NonReentrantLock() {
        isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        NonReentrantLock nr = new NonReentrantLock();
        nr.lock();
        System.out.println("Acquired first lock");
        nr.lock();
        System.out.println("Acquired second lock"); // never printed
    }
}