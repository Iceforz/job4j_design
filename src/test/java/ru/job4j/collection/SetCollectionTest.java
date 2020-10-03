package ru.job4j.collection;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import junit.framework.TestCase;

public class SetCollectionTest {

    @Test
    public void whenHaveSame() {
        SetCollection<Integer> set = new SetCollection<>();
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(2);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));

        assertFalse(it.hasNext());

    }
}