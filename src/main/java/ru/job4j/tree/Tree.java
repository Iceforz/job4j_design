package ru.job4j.tree;

import ru.job4j.generics.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (findBy(child).isEmpty()) {
            Optional<Node<E>> node = findBy(parent);
            if (node.isPresent()) {
                node.get().add(new Node<>(child));
                result  = true;
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return find(x -> x.value.equals(value));
    }

    public boolean isBinary() {
        return find(x -> x.children.size() > 2).isEmpty();
    }

        private Optional<Node<E>> find(Predicate<Node<E>> predicate) {
            Optional<Node<E>> rsl = Optional.empty();
            Queue<Node<E>> data = new LinkedList<>();
            data.offer(this.root);
            while (!data.isEmpty()) {
                Node<E> el = data.poll();
                    if (predicate.test(el)) {
                        rsl = Optional.of(el);
                        break;
                    }
                    data.addAll(el.children);
                }
                return rsl;
    }
}

