package GoogleDoc.models;

public class Document {
    private StringBuilder text;
    private int cursorPosition;
    private int lines;
    public Document() {
        text = new StringBuilder();
        cursorPosition = 0;
        lines = 0;
    }

    public StringBuilder getText() {
        return text;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public void setCursorPosition(int cursorPosition) {
        this.cursorPosition = cursorPosition;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }
    public void appendText(String newText) {
        text.insert(cursorPosition, newText);
        cursorPosition += newText.length();
    }
    public void replaceText(String newText,String oldText) {
        int index = text.indexOf(oldText);
        if (index != -1) {
            text.replace(index, index + newText.length(), newText);
            cursorPosition += newText.length();
        }
    }
    public void moveCursor(String direction) {
        switch (direction.toLowerCase()) {
            case "left":
                cursorPosition = Math.max(0, cursorPosition - 1);
                break;
            case "right":
                cursorPosition = Math.min(text.length(), cursorPosition + 1);
                break;
            case "up":
                cursorPosition = Math.max(0, cursorPosition - 1); // Move up by 10 positions
                break;
            case "down":
                cursorPosition = Math.min(text.length(), cursorPosition + 1); // Move down by 10 positions
                break;
        }
    }
    public void movePage(String direction) {
        switch (direction.toLowerCase()) {
            case "down":
                cursorPosition = Math.max(text.length(), cursorPosition + 10);
                break;
            case "up":
                cursorPosition = Math.max(0, cursorPosition - 10);
                break;
        }
    }
}
//Functionalities
//Append - Add text at the cursor position.
//Replace - Replace text at a specific position.
//Arrow Movements - Move cursor left, right, up, or down.
//Page Up/Page Down - Move the cursor up or down by a page (e.g., 10 lines at a time).