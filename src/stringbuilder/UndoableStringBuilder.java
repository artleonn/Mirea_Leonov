package stringbuilder;

import java.util.Stack;

public class UndoableStringBuilder {
    private StringBuilder stringBuilder;
    private Stack<String> history;

    public UndoableStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.history = new Stack<>();
        saveState();
    }

    private void saveState() {
        history.push(stringBuilder.toString());
    }

    public UndoableStringBuilder append(String str) {
        stringBuilder.append(str);
        saveState();
        return this;
    }

    public UndoableStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        saveState();
        return this;
    }

    public UndoableStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        saveState();
        return this;
    }

    public UndoableStringBuilder reverse() {
        stringBuilder.reverse();
        saveState();
        return this;
    }

    public void undo() {
        if (history.size() > 1) {
            history.pop();
            stringBuilder = new StringBuilder(history.peek());
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
