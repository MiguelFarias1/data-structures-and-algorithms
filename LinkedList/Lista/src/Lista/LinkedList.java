package Lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> start;
    private Node<T> end;

    public void add(T data) {
        if(start == null) {
            this.start = new Node<T>(data);
            this.start.setNext(end);
            this.end = start;
        }

        else {
            this.end.setNext(new Node<T>(data));

            this.end = this.end.getNext();
        }
    }

    private class Itr implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return start != null;
        }

        @Override
        public T next() {

            if(start == null) 
                throw new NoSuchElementException();
            
            T data = start.getData();

            start = start.getNext();

            return data;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }
}