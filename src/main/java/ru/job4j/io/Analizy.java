package ru.job4j.io;
import java.io.*;
import java.util.*;

import static ru.job4j.io.LogFilter.filter;

public class Analizy {
    private static List<String> source = new ArrayList<>();
    private static List<String> target = new ArrayList<>();

    static void unavailable(String xsource, String ytarget) {
        toList(xsource);
        String trigger = null;
        String end = null;
        String result = null;
        for (String line : source) {
            if ((line.contains("400") || line.contains("500"))
                    && trigger == null) {
                trigger = line.substring(4, line.length());
            }
            if ((line.contains("200") || line.contains("300"))
                    && (trigger != null && end == null)) {
                end = line.substring(4, line.length());
                result = trigger + " - " + end;
                trigger = null;
                end = null;
                target.add(result);
            }
        }
        toFile(ytarget);
    }

    private static void toList(String xsource) {
        try (BufferedReader in = new BufferedReader(new FileReader(xsource))) {
            in.lines().forEach(source::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void toFile(String ytarget) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream(ytarget)))) {
            target.forEach(value -> out.write(value + "\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        unavailable("server.log.txt", "server.log.after.txt");
    }
}
