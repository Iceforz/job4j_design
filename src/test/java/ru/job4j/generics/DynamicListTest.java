package ru.job4j.generics;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicListTest {

        @Test
public void whenAddThenGet() {
    DynamicList<String> array = new DynamicList<>();
    array.add("first");
    String rsl = array.get(0);
    assertThat(rsl, is("first"));
}

        @Test
        public void whenAddThenIt() {
            DynamicList<String> array = new DynamicList<>();
            array.add("first");
            String rsl = array.iterator().next();
            assertThat(rsl, is("first"));
        }

        @Test(expected = IndexOutOfBoundsException.class)
        public void whenGetEmpty() {
            DynamicList<String> array = new DynamicList<>();
            array.get(0);
        }

        @Test(expected = IndexOutOfBoundsException.class)
        public void whenGetOutBound() {
            DynamicList<String> array = new DynamicList<>();
            array.add("first");
            array.get(1);
        }

        @Test(expected = NoSuchElementException.class)
        public void whenGetEmptyFromIt() {
            DynamicList<String> array = new DynamicList<>();
            array.iterator().next();
        }

        @Test(expected = ConcurrentModificationException.class)
        public void whenCorruptedIt() {
            DynamicList<String> array = new DynamicList<>();
            array.add("first");
            Iterator<String> it = array.iterator();
            array.add("second");
            it.next();
        }
}