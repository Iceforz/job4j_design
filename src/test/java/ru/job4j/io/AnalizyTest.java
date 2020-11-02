package ru.job4j.io;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void drop() throws IOException {
        File source = folder.newFile("server.log.txt");
        File target = folder.newFile("server.log.after.txt");
        String line = System.lineSeparator();
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(source)))) {
            writer.write("200 10:56:01"
                    + line +
                    "200 10:57:01"
                    + line +
                    "400 10:58:01"
                    + line +
                    "200 10:59:01"
                    + line +
                    "500 11:01:02"
                    + line +
                    "200 11:02:02");
        }
        Analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:58:01 - 10:59:0111:01:02 - 11:02:02"));
    }
}



