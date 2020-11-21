package ru.job4j.serialization.json;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class FileData {

    private Map<String, String> keys = new HashMap<>();
    private final String[] data;


    public FileData(String[] args) {
        this.data = args;
    }

    public boolean valid() {
        File file = new File(directory());
        return file.isDirectory();
    }

    public String getKey(String key) {
        return keys.get(key);
    }

    public void setKey() {
        if (valid()) {
            keys.put("d", directory());
        } else {
            throw new IllegalArgumentException();
        }
        keys.put("o", output());
        keys.put("n", pattern());
        keys.put(searchType(), searchType());
    }

    public String directory() {
        String[] s = data[0].split(" ");
        if (s[4].isEmpty()) {
            throw new IllegalArgumentException();
        }
        return s[4];
    }

    public String pattern() {
        String[] s = data[0].split(" ");
        if (s[6].isEmpty()) {
            throw new IllegalArgumentException();
        }
        return s[6];
    }

    public String searchType() {
        String[] s = data[0].split(" ");
        s = s[7].split("");
        String name = s[1];
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return name;
    }

    public String output() {
        String[] s = data[0].split(" ");
        if (s[9].isEmpty()) {
            throw new IllegalArgumentException();
        }
        return s[9];
    }
}