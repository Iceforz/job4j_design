package ru.job4j.serialization.json;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Company {
    private final String name;
    private final int based;
    private final boolean liquidity;
    private final Politics politics;
    private final Person[] owners;

    public Company(String name, int based, boolean liquidity, Politics politics, Person[] owners) {
        this.name = name;
        this.based = based;
        this.liquidity = liquidity;
        this.politics = politics;
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Company{"
                + "name = " + name + '\''
                + ", based = " + based
                + ", liquidity = " + liquidity
                + ", politics = " + politics
                + ", owners = " + Arrays.toString(owners)
                + '}';
    }

    public static void main(String[] args) {
        final Company Universal = new Company(
                "Universal", 1890, true, new Politics("democrat"),
                new Person[]{new Person("Fill", 32), new Person("Marry", 23)}
        );

        final Gson gson = new GsonBuilder().create();
        String companyJson = gson.toJson(Universal);
        System.out.println(companyJson);
        final Company companyMod = gson.fromJson(companyJson, Company.class);
        System.out.println(companyMod);
    }
}

