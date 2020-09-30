package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    public int indexOf(String id) {
        int point = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                point = i;
            }
        }
        return point;
    }

    @Override
    public void add(T model) {
       mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean rsl = false;
        int point = indexOf(id);
        if (point != 1) {
            mem.set(point, model);
            rsl = true;
        }
        return rsl;
    }


    @Override
    public boolean delete(String id) {
        int point = indexOf(id);
        if (point != -1) {
            mem.remove(point);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int point = indexOf(id);
        if (point != -1) {
            return mem.get(point);
        }
        return null;
    }
}
