import java.util.Stack;

public class UndoableStringBuilder {
    private StringBuilder str;
    private Stack<String> undoStack;

    public UndoableStringBuilder() {
        str = new StringBuilder();
        undoStack = new Stack<>();
    }

    private void maintainUndo() {
        if(str.length() > 0) undoStack.push(str.toString());
    }

    public void append(String value) {
        maintainUndo();
        str.append(value);
    }

    void delete(int start, int end) {
        maintainUndo();
        str.replace(start, end, "");
    }

    public void insert(int offset, String value) {
        maintainUndo();
        str.insert(offset, value);
    }

    public void replace(int start,int end, String value) {
        maintainUndo();
        str.replace(start, end, value);
    }

    public void reverse() {
        maintainUndo();
        str.reverse();
    }

    public void undo() {
        str = new StringBuilder();

        if(undoStack.size() > 0) {
            str.append(undoStack.pop());
        }
    }

    @Override
    public String toString() {
        return str.toString();
    }
}
