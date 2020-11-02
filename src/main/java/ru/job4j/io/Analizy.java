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
            if ((line.contains("400") || line.contains("500")) && trigger == null) {
                trigger = line.substring(4, line.length());
            }
            if ((line.contains("200") || line.contains("300")) && (trigger != null && end == null)) {
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




/*
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Analizy(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines()
                    .filter(s -> /*(s.startsWith("400") || s.startsWith("500")) && ((s.endsWith("200") || s.endsWith("300"))) && (s.startsWith(" ") && s.endsWith("\n")))
                    .forEach(s -> {
                        int index = s.indexOf("\n");
                        values.put(s.substring(0, index),
                                s.substring(index + 1));
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static List<String> filter(String source) {
            int x = 0;
            for (int i = 0; i <= 10000; i++) {
             x += i;
            }
                List<String> lines = new ArrayList<>();
                try (BufferedReader in = new BufferedReader(new FileReader(source))) {

                    int finalX = x;
                    in.lines().filter(s -> (s.startsWith("400") || s.startsWith("500")) && (!(s.endsWith(String.valueOf(finalX))) || s.endsWith(String.valueOf(finalX)))).forEach(lines::add);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return lines;
            }

    public static void save(List<String> log, String target) {
        try (PrintWriter reader = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            log.stream().forEach(x -> reader.write(x + "\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy("server.log.txt");
        analizy.load();
        List<String> log = filter("server.log.txt");
        save(log, "server.log.after.txt");
        System.out.println(log);
        System.out.println(analizy);
    }
}*/
