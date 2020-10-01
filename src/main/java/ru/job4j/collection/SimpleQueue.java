package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        while (!in.isEmpty()) {
            T element = in.pop();
            out.push(element);
        }
        T rsl = out.pop();
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        return rsl;
    }

    public void push(T value) {
        in.push(value);
    }
}
