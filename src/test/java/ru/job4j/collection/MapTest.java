package ru.job4j.collection;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import junit.framework.TestCase;

public class MapTest {

    @Test
    public void whenInsert() {
        Map<Integer, String> hashmap = new Map<>();
        hashmap.insert(0, "a");
        String rsl = hashmap.get(0);
        assertThat(rsl, is("a"));
    }

    @Test
    public void whenInsertThenResize() {
        Map<Integer, String> hashmap = new Map<>();
        hashmap.insert(0, "aa");
        hashmap.insert(1, "aaa");
        hashmap.insert(2, "aaaa");
        hashmap.insert(3, "aaaaa");
        hashmap.insert(4, "aaaaaa");
        hashmap.insert(5, "aaaaaaa");
        hashmap.insert(6, "aaaaaaaa");
        hashmap.insert(7, "aaaaaaaaa");
        hashmap.insert(8, "aaaaaaaaaa");
        hashmap.insert(9, "aaaaaaaaaaa");
        hashmap.insert(10, "aaaaaaaaaaaa");
        hashmap.insert(11, "aaaaaaaaaaaaa");
        hashmap.insert(12, "aaaaaaaaaaaaaa");
        hashmap.insert(13, "aaaaaaaaaaaaaaa");
        hashmap.insert(14, "aaaaaaaaaaaaaaaa");
        hashmap.insert(15, "aaaaaaaaaaaaaaaaa");
        hashmap.insert(16, "aaaaaaaaaaaaaaaaaa");
        hashmap.insert(17, "aaaaaaaaaaaaaaaaaaa");

        String rsl = hashmap.get(17);
        assertThat(rsl, is("aaaaaaaaaaaaaaaaaaa"));
    }

    @Test
    public void whenInsertThenIterator() {
        Map<Integer, String> hashmap = new Map<>();
        hashmap.insert(0, "a");
        hashmap.insert(1, "b");
        Iterator<String> iterator = hashmap.iterator();
        assertThat(iterator.next(), is("a"));
        assertThat(iterator.next(), is("b"));
    }

    @Test
    public void whenInsertThenDelete() {
        Map<Integer, String> hashmap = new Map<>();
        hashmap.insert(0, "a");
        hashmap.insert(1, "b");
       hashmap.delete(0);
        Iterator<String> iterator = hashmap.iterator();
        assertThat(iterator.next(), is("b"));
    }
}