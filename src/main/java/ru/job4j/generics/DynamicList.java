package ru.job4j.generics;

import java.util.*;

public class DynamicList<T> implements Iterable<T> {
    private Object[] list = new Object[10];
    private int size = 0;
    private int modCount = 0;

    public T get(int index) {
        return (T) list[Objects.checkIndex(index, size)];
    }

    public void add(T model) {
        if (list.length == size) {
            list = grow();
        }
        list[size++] = model;
        modCount++;
    }

    private Object[] grow() {
        int oldCapacity = list.length;
        int minCapacity = oldCapacity + (oldCapacity / 2 + 1);
        return Arrays.copyOf(list, minCapacity);
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int expectedModCount = modCount;
            private int point = 0;
            @Override
            public boolean hasNext() {
                return point != size;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return (T) list[point++];
            }
        };
    }
}
