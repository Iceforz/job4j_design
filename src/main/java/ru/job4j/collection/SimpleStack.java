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
        linked.deleteFirst();
        return element;
    }

    public void push(T value) {
        linked.addFirst(value);
    }

    public boolean isEmpty() {
        return linked.isEmpty();
    }
}
