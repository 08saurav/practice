package command.shivendra;

import java.util.LinkedList;
import java.util.Queue;

// user ko login krna , 

// write(text)
// undo(text)

/**
 * Invoker -> println("HBJEH") -> WriteCommand -> Reciever -> History(WriteCommand) -> Execute -> 
 * aInvoker -> Ctrl + Z ->   Reciver -> Command.undo()
 */


/**
 * Reciever(WriteC)
 * abstract UserCommand {
 * UserCommand(Object data) {
 * this.data = data;}
 * Object data;
 * abstract function execute();
 * }
 * 
 * class LoginCommand extends UserCommand {
 * LoginCommand(Object data) {
 * super(data);
 * }
 * }
 * 
 * class DashboardAudit {
 *  UserCommand userCommand;
 *  audit() {
//  *  
 * }
 * }
 * 
 * 
 * 
 * 
 */
// login (command)
// command object (request) -> authorization -> execute -> output -> action ->log

/*                -------------------------------- Command Design Pattern --------------------------------
 * Suppose we have a request object that need not be processes immediately i.e. have to passed through multiple middlewares
 * e.g. logger, authoriser, auditor etc. they it would be better to have request object(can be called command) and we will
 * have sender(invoker) and reciever(executor)
 */

/* The Command Design Pattern is a behavioral design pattern that encapsulates a request as an object,
 * allowing you to parameterize objects with different requests, queue or log requests,
 * and support undoable operations.
 * It decouples the sender (the object that initiates the request) from the receiver (the object that performs the request).
 */

 /* Components of Command Design Pattern:
  * Command: An interface or abstract class that defines the execute() method to perform an action.
  * Concrete Command: A class that implements the Command interface and defines the specific actions to be executed on the receiver.
  * Receiver: The actual object that performs the business logic of the command.
  * Invoker: The object that triggers the execution of the command.
  * Client: The object that creates the command, associates it with a receiver, and assigns it to an invoker.
  */

/* When to Use the Command Pattern
   To encapsulate a request as an object, enabling you to:
   1. Queue commands.
   2. Log commands for audit or debugging.
   3. Support undo/redo functionality.
   4. To decouple the sender of a request from the receiver.
   5. When you want to implement a transactional model where operations can be executed, reversed, or retried.
 */

/*
Benefits of the Command Pattern
Flexibility:
Commands can be dynamically assigned, making the system more configurable and extensible.

Reusability:
Commands can be reused in different contexts (e.g., for manual triggers, automation, or undo operations).

Separation of Concerns:
The sender doesn’t need to know how the receiver performs the action, adhering to the Single Responsibility Principle.

Support for Complex Operations:
Commands can encapsulate a sequence of operations (e.g., a macro command).
*/

/*   Real World Examples  */
/*
GUI Applications:
Buttons, menus, or keyboard shortcuts trigger commands (e.g., "Save", "Undo", "Redo").

Task Schedulers:
Queue and execute tasks like sending emails or generating reports at specific times.

Home Automation Systems:
Commands are used to control devices (lights, fans, TVs) based on user input or triggers.

Undo/Redo in Text Editors:
Each operation (e.g., typing, deleting) is encapsulated as a command for undo/redo functionality.

Game Development:
Player actions (move, attack) are stored as commands to support undo, replay, or AI simulations.
*/

public class Runner {
    public static void main(String[] args) {
        System.out.println("Hello to Command Design Pattern.");
        NotificationScheduler scheduler = new NotificationScheduler();

        // Create tasks
        NotificationService emailTask = new SendEmailService("user@example.com", "Welcome to our service!", "Welcome to our service");
        NotificationService reportTask = new SendSMSService("6783287387", "Welcome to our service!");
        NotificationService logCleanupTask = new SendWhatsappService("6783287387", "Welcome to our service!");

        // Schedule tasks
        scheduler.addTask(emailTask);
        scheduler.addTask(reportTask);
        scheduler.addTask(logCleanupTask);

        // Execute all tasks
        System.out.println("Executing tasks...");
        scheduler.executeAll();
    }
}

interface NotificationService {
    void execute();
}

class SendEmailService implements NotificationService{
    private String recipient;
    private String message;
    private String subject;

    public SendEmailService(String recipient, String message, String subject) {
        this.recipient = recipient;
        this.message = message;
        this.subject = subject;
    }

    @Override
    public void execute() {
        System.out.println("Sending email to " + recipient + " with message: " + message);
    }
}

class SendSMSService implements NotificationService {
    private String recipient;
    private String message;

    public SendSMSService(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println("Sending SMS to " + recipient + " with message: " + message);
    }
}

class SendWhatsappService implements NotificationService {
    private String recipient;
    private String message;

    public SendWhatsappService(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println("Sending Whatsapp to " + recipient + " with message: " + message);
    }
}

class NotificationScheduler {
    Queue<NotificationService>scheduledQueue;
    Queue<NotificationService>executedTask;

    public NotificationScheduler() {
        scheduledQueue = new LinkedList<>();
        executedTask = new LinkedList<>();
    }

    public void addTask(NotificationService ns) {
        scheduledQueue.add(ns);
    }

    public void executeAll() {
        while (!scheduledQueue.isEmpty()) {
            NotificationService task = scheduledQueue.poll();
            task.execute();
            executedTask.add(task); // save it for further logging or report generation etc.
        }
    }

    public void retryFailedTaks() {
        
    }

    public void log() {
        while (!scheduledQueue.isEmpty()) {
            NotificationService task = executedTask.poll();
            // audit
        }
    }
}


