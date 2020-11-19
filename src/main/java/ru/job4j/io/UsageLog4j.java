package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        float x = 1;
        double b = 15;
        char sex = 0;
        boolean target = false;
        long y = 22;
        short z = 12;
        LOG.debug("User info name : {}, age : {}, float : {},"
                        +
                " double : {}, char : {}, boolean : {}, long : {}, short : {}",
                name, age, x, b, sex, target, y, z);

    }
}

