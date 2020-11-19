package ru.job4j.generics;

public class Node<E> {
    private E item;
   private Node<E> next;
   private Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}

