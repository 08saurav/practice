package command.shivendra;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        CommandManager manager = new CommandManager();
        Command addHello = new AddTextCommand(editor, "Hello ");
        Command addWorld = new AddTextCommand(editor, "World!");
        manager.executeCommand(addHello);
        manager.executeCommand(addWorld);
        manager.undo();
        manager.redo();
        Command removeLastWord = new RemoveTextCommand(editor, 6);
        manager.executeCommand(removeLastWord);
        manager.undo();
    }
}

// Text Editor using Command

// Command Interface
interface Command {
    void execute();
    void undo();
}

// Reciever
class TextEditor {
    private StringBuilder text = new StringBuilder();
    public void addText(String newText) {
        text.append(newText);
        System.out.println("Text after adding: " + text.toString());
    }

    public void removeText(int length) {
        int start = text.length() - length;
        if (start >= 0) {
            text.delete(start, text.length());
            System.out.println("Text after removing: " + text.toString());
        }
    }

    public String getText() {
        return text.toString();
    }
}

// Concrete Command
class AddTextCommand implements  Command {
    // Reciever on which operation is performed
    TextEditor editor;
    String textToAdd;

    AddTextCommand(TextEditor editor, String textToAdd) {
        this.editor = editor;
        this.textToAdd = textToAdd;
    }

    public void execute() {
        editor.addText(textToAdd);
    }

    public void undo() {
        editor.removeText(textToAdd.length());
    }
}

class RemoveTextCommand implements Command {
    private TextEditor editor;
    private String removedText;

    public RemoveTextCommand(TextEditor editor, int length) {
        this.editor = editor;
        if (editor.getText().length() >= length) {
            this.removedText = editor.getText().substring(editor.getText().length() - length);
        } else {
            this.removedText = editor.getText();
        }
    }

    @Override
    public void execute() {
        editor.removeText(removedText.length());
    }

    @Override
    public void undo() {
        editor.addText(removedText);
    }
}

// Invoker
class CommandManager {
    private Stack<Command> commandHistory = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
        redoStack.clear(); // Clear redo stack after new command
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
            redoStack.push(command);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            commandHistory.push(command);
        } else {
            System.out.println("Nothing to redo.");
        }
    }
}


