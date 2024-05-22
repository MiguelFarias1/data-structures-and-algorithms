package src.implementations;

import java.util.Iterator;
import java.util.Objects;

public class Queue<T> implements Iterable<T> {

    private Node<T> node;
    private Node<T> tail;

    public void enqueue(T element) {

        Objects.requireNonNull(element, "The queue does not allows null elements");

        if(this.node == null) {
            node = new Node<>(element);
            tail = node;
        }

        else {
            Node<T> newNode = new Node<>(element);

            tail.setNext(newNode);

            tail = tail.getNext();
        }
    }

    public void dequeue() {

        if(this.node != null && this.node.getNext() != null)
            this.node = this.node.getNext();

        else
            this.node = null;    
    }

    public void print() {

        var auxiliar = this.node;

        if(auxiliar == null) return;

        while (auxiliar != null) {
            System.out.println(auxiliar.getData());

            auxiliar = auxiliar.getNext();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {

            T data = node.getData();

            node = node.getNext();

            return data;
        }

    }
}