package ru.job4j.io;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleChat {
    private final String path = "./src/main/data/path.txt";
    private String botAnswers = "./src/main/data/Answers.txt";

    public void run() {
        List<String> strList = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {

            String answer;
            boolean isRespond = true;
            String inputLine = scanner.nextLine();

            String finish = "закончить";
            while (!inputLine.equals(finish)) {
                String aContinue = "продолжить";
                String stop = "стоп";
                isRespond = !inputLine.equals(stop) && (inputLine.equals(aContinue) || isRespond);
                strList.add(inputLine);
                if (isRespond) {
                    answer = getRandomAnswer();
                    System.out.println(answer);
                    strList.add(answer);
                }
                inputLine = scanner.nextLine();
            }
        }
        printToFile(strList);
    }

    private String getRandomAnswer() {
        String answer = "";
        try {
            Random random = new Random();
            List<String> strings = Files.readAllLines(Paths.get(botAnswers));
            int index = random.nextInt(strings.size());
            answer = strings.get(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    private void printToFile(List<String> outputStrList) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(path, true)))) {
            outputStrList.forEach(s -> out.write(s + System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.run();
    }
}