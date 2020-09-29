package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIt(int[] data) {
        this.data = data;
    }

    private boolean compile() {
        return point < data.length;
    }

    @Override
    public boolean hasNext() {
        if (!compile()) {
            return false;
        }
        if (data[point] % 2 != 0) {
            point++;
        }
        return compile();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
