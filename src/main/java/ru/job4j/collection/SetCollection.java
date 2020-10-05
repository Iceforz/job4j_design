package ru.job4j.collection;
import ru.job4j.generics.SimpleArray;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SetCollection<E> implements Iterable<E> {

    private SimpleArray<E> array = new SimpleArray<E>(10);

    public void add(E e) {
        if (!array.contains(e)) {
            array.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }
}
