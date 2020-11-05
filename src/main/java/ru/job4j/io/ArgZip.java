package ru.job4j.io;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ArgZip {
    private final ArgsName data;

    public ArgZip(String[] args) {
        data = ArgsName.of(args);
    }

    public boolean valid() {
        if (data.get("o") == null || data.get("e") == null) {
            return false;
        }
        File f = new File(data.get("d"));
        return f.isDirectory();
    }

    public String directory() {
        return data.get("-d");
    }

    public String exclude() {
        return data.get("-e");
    }

    public String output() {
        return data.get("-o");
    }
}