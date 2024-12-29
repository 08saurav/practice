package multithreading.shivendra;

/* Thread LifeCycle
 * New
 * Active -> (Runnable/Running) -> a thread is running then context switch happens and went to runnable state (maybe in queue or priority queue)
 * Blocked Waiting -> Waiting for notify or notifyAll to resume execution
 * Timed Waiting -> In Java concurrency, the TIMED_WAITING state refers to a thread that is waiting for another thread or condition 
 *                  to complete its task for a specified period of time.
 *                  Unlike the WAITING state, which blocks a thread indefinitely, a thread in the TIMED_WAITING state remains blocked only for a defined duration.
 * Terminated -> reached its terminal state
 */

/**
 * Constructors of Thread Class
 * Thread()
 * Thread(String name)
 * Thread(Runnable r)
 * Thread(Runnable r, String name)
 * 
 * 
 * Thread Class Methods
 * public void run(): is used to perform action for a thread.
 * public void start(): starts the execution of the thread.JVM calls the run()
 * method on the thread.
 * public void sleep(long miliseconds): Causes the currently executing thread to
 * sleep (temporarily cease execution) for the specified number of milliseconds.
 * public void join(): waits for a thread to die.
 * public void join(long miliseconds): waits for a thread to die for the
 * specified miliseconds.
 * public int getPriority(): returns the priority of the thread.
 * public int setPriority(int priority): changes the priority of the thread.
 * public String getName(): returns the name of the thread.
 * public void setName(String name): changes the name of the thread.
 * public Thread currentThread(): returns the reference of currently executing
 * thread.
 * public int getId(): returns the id of the thread.
 * public Thread.State getState(): returns the state of the thread.
 * public boolean isAlive(): tests if the thread is alive.
 * public void yield(): causes the currently executing thread object to
 * temporarily pause and allow other threads to execute.
 * public void suspend(): is used to suspend the thread(depricated).
 * public void resume(): is used to resume the suspended thread(depricated).
 * public void stop(): is used to stop the thread(depricated).
 * public boolean isDaemon(): tests if the thread is a daemon thread.
 * public void setDaemon(boolean b): marks the thread as daemon or user thread.
 * public void interrupt(): interrupts the thread.
 * public boolean isInterrupted(): tests if the thread has been interrupted.
 * public static boolean interrupted(): tests if the current thread has been
 * interrupted.
 */

/**
 * Thread.sleep(millis, nanos)
 * Thread.join() -> indefinite wait
 * Thread.sleep(millis) -> wait upto milliseconds
 * Thread.sleep(millis, nanos) -> precise waiting
 */

/* Thread Priority can be between 1 to 10
 * public static int MIN_PRIORITY
 * public static int NORM_PRIORITY
 * public static int MAX_PRIORITY
 */

public class ThreadLifeCycle {
    public static void main(String[] args) {
        final Object LOCK = new Object();
        Thread t = new Thread(() -> {
            System.out.println("Thread is running.....");
        }, "Thread-0");

        System.out.println("State of Thread Just After Creation : " + t.getState());

        Thread runnableThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {

                }
            }
        }, "RunnableThread");

        runnableThread.start();

        Thread waitingThread = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": Waiting...");
                    LOCK.wait(); // WAITING
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        waitingThread.start();

        Thread timedWaitingThread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + ": Sleeping...");
                Thread.sleep(500); // TIMED_WAITING
                System.out.println(Thread.currentThread().getName() + ": Woke up...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        timedWaitingThread.start();

        // Thread in BLOCKED state
        Thread blockedThread = new Thread(() -> {
            synchronized (LOCK) {
                System.out.println(Thread.currentThread().getName() + ": Acquired LOCK...");
            }
        });

        // Acquiring lock in main thread to block another thread
        synchronized (LOCK) {
            blockedThread.start();

            // Displaying thread states
            try {
                Thread.sleep(100); // Allow time for threads to enter different states
                System.out.println("State of runnableThread: " + runnableThread.getState()); // RUNNABLE or
                                                                                             // TIMED_WAITING
                System.out.println("State of waitingThread: " + waitingThread.getState()); // WAITING
                System.out.println("State of timedWaitingThread: " + timedWaitingThread.getState()); // TIMED_WAITING
                System.out.println("State of blockedThread: " + blockedThread.getState()); // BLOCKED
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Notify waiting thread to proceed
            LOCK.notify();
        }

        // Wait for all threads to finish
        try {
            t.start();
            t.join(); // Ensure TERMINATED state
            runnableThread.join();
            waitingThread.join();
            timedWaitingThread.join();
            blockedThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display TERMINATED states
        System.out.println("State of newThread: " + t.getState()); // TERMINATED
        System.out.println("State of runnableThread: " + runnableThread.getState()); // TERMINATED
        System.out.println("State of waitingThread: " + waitingThread.getState()); // TERMINATED
        System.out.println("State of timedWaitingThread: " + timedWaitingThread.getState()); // TERMINATED
        System.out.println("State of blockedThread: " + blockedThread.getState()); // TERMINATED
    }
}
