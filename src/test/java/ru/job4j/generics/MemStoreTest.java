package ru.job4j.generics;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import junit.framework.TestCase;

public class MemStoreTest {

    @Test
    public void userStoreTest() {
        UserStore userStore = new UserStore();

        userStore.add(new User("1", "Ilya"));
        assertThat(userStore.findById("1").getName(), is("Ilya"));

        userStore.replace("1", new User("2", "Ivan"));
        assertThat(userStore.findById("2").getName(), is("Ivan"));

        userStore.delete("2");
        assertThat(userStore.findById("2"), is(IsNull.nullValue()));
}
}