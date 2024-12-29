package multithreading.shivendra;

/*
 * Shutdown Hook in Java
  A shutdown hook in Java is a special mechanism that allows you to execute some cleanup code (e.g., closing resources, saving state, logging, etc.) when the Java Virtual Machine (JVM) shuts down. It is particularly useful for performing tasks during application termination.

    Key Features
    Execution at JVM Termination:

    Executes registered shutdown hooks when the JVM is shutting down normally (e.g., program termination, System.exit()).
    Not for Abrupt Shutdowns:

    Does not execute for forceful terminations like kill -9 on Unix or equivalent actions on other systems.
    Multiple Hooks:

    You can register multiple shutdown hooks. They will execute in an unspecified order.
    Thread Execution:

    Each hook runs in its own thread.
 */

public class ShutdownHook {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown Hook is running, cleaning up resources...");
        }));

        System.out.println("Application is running...");
        try {
            Thread.sleep(3000); // Simulating application work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Application is shutting down.");
    }
}
