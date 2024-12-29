package multithreading.shivendra;

/*
 * Daemon Threads in Java
In Java, a daemon thread is a low-priority background thread that provides support or services to other threads in the application. Unlike user threads, daemon threads are terminated by the JVM as soon as all user threads finish execution.

Key Characteristics
Background Service: Runs in the background to perform tasks like garbage collection, logging, or monitoring.
Lifecycle: JVM terminates daemon threads automatically when all user threads have completed.
Set Daemon Status: A thread can be set as a daemon thread using thread.setDaemon(true) before it starts.
Examples: Garbage collector, thread pools, and background tasks.
 */

public class DaemonThreads {
    public static void main(String[] args) {
        Thread userThread = new Thread(() -> {
            System.out.println("User thread started: Processing requests...");
            try {
                Thread.sleep(5000); // Simulating work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("User thread finished: Requests processed!");
        });

        // Daemon thread for monitoring/logging system health
        Thread daemonThread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Daemon thread: Logging system status...");
                    Thread.sleep(1000); // Simulating periodic logging
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Set the second thread as a daemon thread
        daemonThread.setDaemon(true);

        // Start both threads
        daemonThread.start();
        userThread.start();

        // Main thread waits for userThread to complete
        try {
            userThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished: Daemon thread will terminate now!");
    }

}
