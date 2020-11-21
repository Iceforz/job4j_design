package ru.job4j.serialization.json;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


import static java.nio.file.FileVisitResult.CONTINUE;

public class FilesFinder {

    public List<Path> search(FileData fileData, Predicate<Path> condition) throws IOException {
        SearchFiles searchFiles = new SearchFiles(condition);
        Files.walkFileTree(Path.of(fileData.directory()), searchFiles);
        return searchFiles.getPaths();
    }

    public void saveLog(List<Path> paths, String outfile) throws IOException {
        Path tempDir = Files.createTempDirectory(null).toAbsolutePath();
        String pathLogFile = tempDir.resolve(outfile).toString();
        System.out.println(pathLogFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(pathLogFile, Charset.forName("UTF-8"), true))) {
            for (Path path : paths) {
                System.out.println(path);
                bufferedWriter.write(path.toString() + System.lineSeparator());
            }
        }
        Files.deleteIfExists(Paths.get(pathLogFile));
        Files.deleteIfExists(tempDir);

    }

    public static class SearchFiles extends SimpleFileVisitor<Path> {
        private List<Path> files = new ArrayList<>();
        private Predicate<Path> predicate;

        public SearchFiles(Predicate<Path> predicate) {
            this.predicate = predicate;
        }

        public List<Path> getPaths() {
            return files;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (predicate.test(file)) {
                files.add(file);
            }
            return CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        FileData fileData = new FileData(new String[]{"java -jar find.jar -d C:/ -n *.txt -m -o log.txt"});
        FilesFinder filesFinder = new FilesFinder();
        fileData.setKey();
        Predicate<Path> condition = File.newCondition(fileData);
        List<Path> paths = filesFinder.search(fileData, condition);
        filesFinder.saveLog(paths, fileData.getKey("o"));
    }
}