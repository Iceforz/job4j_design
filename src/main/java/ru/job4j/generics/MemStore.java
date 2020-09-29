package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
       mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean rsl = false;
        int point = mem.indexOf(findById(id));
        if (point != 1) {
            mem.set(point, model);
            rsl = true;
        }
        return rsl;
    }


    @Override
    public boolean delete(String id) {
        int point = mem.indexOf(findById(id));
        if (point != -1) {
            mem.remove(point);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int point = mem.indexOf(findById(id));
        if (point != -1) {
            return mem.get(point);
        }
        return null;
    }
}
