package ru.job4j.io;

import com.sun.jdi.IntegerValue;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
       // System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            System.out.println(String.format("/File name: %s /File size: %d",
                    subfile.getName(), subfile.length()));
        }
    }
}

