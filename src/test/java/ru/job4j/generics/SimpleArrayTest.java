package ru.job4j.generics;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import junit.framework.TestCase;

public class SimpleArrayTest {
    SimpleArray<Integer> simpleArray = new SimpleArray<>(4);

    @Test
    public void testSet() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.set(0, 5);
        assertThat(simpleArray.get(0), is(5));
    }

    @Test
    public void testRemove() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.remove(1);
        assertThat(simpleArray.get(2), is(4));
    }

    @Test
    public void testGet() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(3), is(4));
    }

    @Test
    public void testIterator() {
        Iterator<Integer> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(false));
        simpleArray.add(1);
        assertThat(iterator.hasNext(), is(true));
        simpleArray.add(2);
        assertThat(iterator.hasNext(), is(true));
        simpleArray.add(3);
        assertThat(iterator.hasNext(), is(true));
        simpleArray.add(4);
        assertThat(iterator.hasNext(), is(true));

        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(false));
    }
}