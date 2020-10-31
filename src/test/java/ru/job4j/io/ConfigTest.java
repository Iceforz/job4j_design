package ru.job4j.io;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void firstString() {
        String path = "app.properties.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.dialect"),
                is("org.hibernate.dialect.PostgreSQLDialect")
        );
    }

    @Test
    public void secondString() {
        String path = "app.properties.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.url"),
                is("jdbc:postgresql://127.0.0.1:5432/trackstudio")
        );
    }
}
