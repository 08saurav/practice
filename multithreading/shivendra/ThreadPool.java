package multithreading.shivendra;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 
 */

public class ThreadPool {
    public static void main(String[] args) {

        // fixedThreadPool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            int taskNumber = i;
            fixedThreadPool.execute(() -> {
                System.out.println("Fixed Thread : " + Thread.currentThread().getName());
                System.out.println("Task " + taskNumber + " executed by " + Thread.currentThread().getName());
            });
        }

        fixedThreadPool.shutdown();

        // Cached ThreadPool

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 1; i <= 10; i++) {
            int taskNumber = i;
            cachedThreadPool.execute(() -> {
                System.out.println("Cached Thread : " + Thread.currentThread().getName());
                System.out.println("Task " + taskNumber + " executed by " + Thread.currentThread().getName());
            });
        }

        cachedThreadPool.shutdown();

    }

}
