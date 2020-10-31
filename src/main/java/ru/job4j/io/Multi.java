package ru.job4j.io;

import java.io.FileOutputStream;

public class Multi {
    public static void main(String[] args) {
        Multi multi = new Multi();
        multi.tableMulti(10, 10);

    }

    public void tableMulti(int x, int y) {
        try (FileOutputStream fos = new FileOutputStream("multiplicationTable")) {
            for (int i = 1; i < x; i++) {
                for (int z = 1; z < y; z++) {
                    fos.write((i + " * " + z + " = " + i * z + "\n").getBytes());
                }
                fos.write("\n".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

