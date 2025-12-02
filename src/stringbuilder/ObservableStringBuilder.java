package stringbuilder;

import java.util.ArrayList;
import java.util.List;

public class ObservableStringBuilder {
    private StringBuilder stringBuilder;
    private List<StringBuilderObserver> observers;

    public ObservableStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.observers = new ArrayList<>();
    }


    public String getString() {
        return stringBuilder.toString();
    }

    public void addObserver(StringBuilderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StringBuilderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (StringBuilderObserver observer : observers) {
            observer.onStringBuilderChanged(this);
        }
    }

    public ObservableStringBuilder append(String str) {
        stringBuilder.append(str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder reverse() {
        stringBuilder.reverse();
        notifyObservers();
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}