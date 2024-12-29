package multithreading.shivendra;

import java.util.ArrayList;
import java.util.List;
/* Threads : They are smallest unit of process that share memory but can switch context easily  */

/**
 * Suppose we are building a system where:
 * Multiple worker threads process data tasks.
 * The main thread waits for all worker threads to complete.
 * Some threads must wait for notifications before they can proceed.
 */

public class Multi {
    protected static final Object LOCK = new Object();
    static boolean dataReady = false;

    public static void main(String[] args) {
        List<WorkerThread> threads = new ArrayList<>();
        int numWorkers = 3;

        for (int i = 1; i <= numWorkers; i++) {
            WorkerThread w = new WorkerThread("thread-" + i);
            threads.add(w);
            w.start();
        }

        Thread dataPreparer = new Thread(() -> {
            synchronized (LOCK) {
                System.out.println(Thread.currentThread().getName() + ": Preparing data...");
                try {
                    Thread.sleep(2000); // Simulate data preparation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dataReady = true;
                System.out.println(Thread.currentThread().getName() + ": Data ready. Notifying workers...");
                LOCK.notifyAll(); // Notify all waiting threads
            }

        }, "Data-Preparer");
        dataPreparer.start();

        for (WorkerThread w : threads) {
            try {
                w.join();
            } catch (Exception e) {
            }
        }

        System.out.println("Checking thread states:");
        for (WorkerThread worker : threads) {
            System.out.println(worker.getName() + ": " + worker.getState());
        }

        System.out.println("All tasks completed.");
    }
}

class WorkerThread extends Thread {
    public WorkerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (Multi.LOCK) {
            System.out.println(Thread.currentThread().getName() + ": Waiting for data...");
            while (!Multi.dataReady) {
                try {
                    Multi.LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": Data received. Processing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": Task completed.");
        }
    }
}
