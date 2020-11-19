package ru.job4j.serialization.json;

public class Politics {
    private final String name;

    public Politics(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "name ='" + name + '\'' + '}';
    }
}

