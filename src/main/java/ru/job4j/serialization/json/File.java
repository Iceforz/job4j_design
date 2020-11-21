package ru.job4j.serialization.json;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class File {

    public static Predicate<Path> newCondition(FileData data) {
    String s = data.searchType();
    Predicate<Path> result = predicate -> true;
    switch (s.toLowerCase()) {
        case "f":
            result = new RegexSearchCondition(data.pattern());
            break;

        case "m":
            result = new RegexSearchCondition(preparePattern(data.pattern()));
            break;

        case "r":
            result = p -> p.toFile().getName().matches(data.pattern());
            break;

        default:
            break;
    }

    return result;
}

private static class RegexSearchCondition implements Predicate<Path> {

    private final Pattern pattern;

    public RegexSearchCondition(String name) {
        this.pattern = Pattern.compile(name);
    }

    @Override
    public boolean test(Path path) {
        return pattern.matcher(path.toFile().getName()).matches();
    }
}

    private static String preparePattern(String pattern) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == '*') {
                stringBuilder.append(".*");
            } else if (c == '.') {
                stringBuilder.append("\\.");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
