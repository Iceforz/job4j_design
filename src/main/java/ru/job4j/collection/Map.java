package ru.job4j.collection;

import java.util.*;

public class Map<K, V> implements Iterable {

  /*  private Node<K, V>[] table;
    private int count = 0;
    private int size = 0;
    private int modCount = 0;
    private float loadFactor = 0.75f;


   static class Node<K, V> {
        public K key;
        public V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return 16 * key.hashCode() * value.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Node) {
                Node<K, V> node = (Node) o;
                if (!Objects.equals(this.key, node.key)) {
                    return false;
                }
                if (!Objects.equals(this.value, node.value)) {
                    return false;
                }
            }
            return true;
        }
    }
    public int size() {
        return this.size();
    }

    public boolean insert(K key, V value) {
        if (count / table.length >= loadFactor) {
            resize();
        }
        if (key != null) {
            Node<K, V> element = new Node<>(key, value);
            int index = getIndex(key.hashCode());
            if (table[index] == null) {
                table[index] = element;
                count++;
                modCount++;
                size++;
                return true;
            } else if (table[index].getKey().equals(key)) {
                table[index].setValue(value);
            }
        }
        return false;
    }

    public V get(K key) {
        Node<K, V> element = table[getIndex(key.hashCode())];
        if (key.equals(element.getKey())) {
            return element.getValue();
        }
        return null;
    }

    public boolean delete(K key) {
        if (key != null) {
            int index = getIndex(key.hashCode());
            if (table[index].getKey().equals(key)) {
                table[index] = null;
                count--;
                modCount++;
                size--;
                return true;
            }
        }
        return false;
    }

    private int getIndex(int hash) {
        return Math.abs(hash) % table.length;
    }

    public void resize() {
        Node[] tempTable = table;
        table = new Node[table.length * 2];
        for (Node<K, V> node : tempTable) {
            insert(node.getKey(), node.getValue());
            count--;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int cursor = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = cursor; i < table.length; i++) {
                    if (table[i] != null) {
                        result = true;
                        cursor = i;
                        break;
                    }
                }
                return result;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (table[cursor] == null && cursor < table.length) {
                    cursor++;
                }
                return (V) table[cursor++].getValue();
            }
        };
    }
}
*/

    static final float loadFactor = 0.75f;
    private Node<K, V>[] table;
    private int capacity = 16;
    private int size = 0;
    private int modCount = 0;

    static class Node<K, V> {
        private final int hash;
        private final K key;
        private V value;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public final K getKey()        {
            return key;
        }

        public final V getValue()      {
            return value;
        }
    }

    public int hash(Object key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    private int getIndex(K key) {
        return (capacity - 1) & hash(key);
    }

    private void resize() {
        if (table == null) {
            table = (Node<K, V>[]) new Node[capacity];
        } else {
            capacity = capacity << 1;
            table = Arrays.copyOf(table, capacity);
        }
    }

    public boolean insert(K key, V value) {
        if (table == null || size > loadFactor * capacity) {
            resize();
        }
        Node<K, V> n = new Node<>(hash(key), key, value);
        int index = getIndex(key);
        if (table[index] != null) {
            return false;
        }
        table[index] = n;
        modCount++;
        size++;
        return true;
    }

    public V get(K key) {
        int index = getIndex(key);
        int validatedIndex = Objects.checkIndex(index, size);
        if (table[validatedIndex] == null) {
            return null;
        }
        return table[validatedIndex].getValue();
    }

    public boolean delete(K key) {
        int index = getIndex(key);
        int validatedIndex = Objects.checkIndex(index, size);
        if (table[validatedIndex] == null) {
            return false;
        }
        table[validatedIndex] = null;
        modCount++;
        size--;
        return true;
    }

    @Override
    public Iterator<V> iterator() {
        int expectedModCount = modCount;
        return new Iterator<>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                if (size == 0) {
                    return false;
                }
                for (int i = point; i <= size; i++) {
                    if (table[i] != null) {
                        point = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public V next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point++].getValue();
            }
        };
    }
}

