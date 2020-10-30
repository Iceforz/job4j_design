package ru.job4j.collection;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;

public class SimpleHashMapTest {

    @Test
    public void whenAddThenTrue() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        boolean result = map.insert("one", 1);
        assertThat(result, is(true));
    }
    @Test
    public void whenAddThenSizeGrowUp() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("one", 1);
        assertThat(map.getSize(), is(1));
    }
    @Test
    public void whenAdd2EqualsKeyThenFalse() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("one", 1);
        boolean result = map.insert("one", 2);
        assertThat(result, is(false));
    }
    @Test
    public void whenAdd2ElementThenGetFirst() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("one", 1);
        map.insert("two", 2);
        int result = map.get("one");
        assertThat(result, is(1));
    }
    @Test
    public void whenDeleteThenTrue() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("one", 1);
        map.insert("two", 2);
        boolean result = map.delete("one");
        assertThat(result, is(true));
    }
    @Test
    public void whenDeleteThenSizeCountDown() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("one", 1);
        map.insert("two", 2);
        map.delete("one");
        int result = map.getSize();
        assertThat(result, is(1));
    }

    @Test
    public void whenAdd2ElementThenIteratorNextReturnOne() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("one", 1);
        map.insert("two", 2);
        Iterator<SimpleHashMap.Node<String, Integer>> iterator = map.iterator();
        int result = iterator.next().getValue();
        assertThat(result, is(1));

    }

    @Test
    public void whenAdd2ElementThenHasNextReturnTrue() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("one", 1);
        map.insert("two", 2);
        Iterator<SimpleHashMap.Node<String, Integer>> iterator = map.iterator();
        boolean result = iterator.hasNext();
        assertThat(result, is(true));
    }
}