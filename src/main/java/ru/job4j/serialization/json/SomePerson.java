package ru.job4j.serialization.json;

import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.io.Contact;

public class SomePerson {

    private final boolean sex;
    private final int age;
    private final Contactt contactt;
    private final String[] statuses;

    public SomePerson(boolean sex, int age, Contactt contactt, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contactt = contactt;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contactt
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) {
        final SomePerson person = new SomePerson(false, 30, new Contactt("11-111"), "Worker", "Married");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        /* Модифицируем json-строку */
        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        final SomePerson personMod = gson.fromJson(personJson, SomePerson.class);
        System.out.println(personMod);
    }

}