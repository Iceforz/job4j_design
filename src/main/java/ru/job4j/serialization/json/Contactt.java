package ru.job4j.serialization.json;

public class Contactt {
    private final String phone;

    public Contactt(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}

