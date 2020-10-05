package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] simpleArray;
    private int count = 0;
    private int size;

    public SimpleArray(int size) {
            simpleArray = (T[]) new Object[size];
            this.size = size;
        }

    public void add(T model) {
           simpleArray[count++] = model;
        }

        public void set(int index, T model) {
            simpleArray[Objects.checkIndex(index, count)] = model;
        }

            public void remove(int index) {
                Objects.checkIndex(index, count);
                System.arraycopy(simpleArray, index + 1, simpleArray, index, simpleArray.length - index - 1);
                simpleArray[simpleArray.length - 1] = null;
                count--;
            }

            public T get(int index) {
                return simpleArray[index];
            }

    public boolean contains(T model) {
        boolean result = false;
        for (int i = 0; i < count; i++) {
            if (Objects.equals(get(i), model)) {
                result = true;
                break;
            }
        }
        return result;
    }

            @Override
            public Iterator<T> iterator() {
            return new Iterator<T>() {
                private int point = 0;

                @Override
                public boolean hasNext() {
                    return point < count;
                    }

                    @Override
                    public T next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return simpleArray[point++];
                    }
                };
            }
        }
