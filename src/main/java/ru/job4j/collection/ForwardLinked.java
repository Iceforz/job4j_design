package ru.job4j.collection;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> end;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            end = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        end = node;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            Node<T> node = head;
            head = head.next;
            node.next = null;
        }
    }

    public T deleteLast() {
        T element;
        if (head == null){
            throw new NoSuchElementException();
        } else if (head == end) {
            element = head.value;
            head = null;
            return element;
        }
        while (head.next != end) {
            head = head.next;
        }
        element = end.value;
        end = head;
        return element;
    }

        @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}