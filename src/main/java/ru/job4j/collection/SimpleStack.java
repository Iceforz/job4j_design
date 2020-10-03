package ru.job4j.collection;

import java.util.Iterator;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        Iterator<T> iterator = linked.iterator();
        T element = null;
        while (iterator.hasNext()) {
            element = iterator.next();
        }
        linked.deleteLast();
        return element;
    }

    public void push(T value) {
        linked.add(value);
    }

    public boolean isEmpty() {
        return linked.isEmpty();
    }
}
