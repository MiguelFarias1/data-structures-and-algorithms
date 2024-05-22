package implementations;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * A generic class that holds a value of type T which must implement Comparable<T>.
 *
 * @param <T> the type of the value, which must implement Comparable<T>
 */
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
    
    private Node<T> node;
    private Integer size = 0;

    /**
     * This method add in the list based in the result of compareTo()
     * @param <T> the type of the values, which must implement {@link Comparable}
     * @param element the element to be added in the tree
     */

    public void add(T element) {

        this.node = add(this.node, element);

        size++;
    }

    /**
     * Returns the maximum of two {@link Comparable} values.
     *
     * @param <T> the type of the values, which must implement {@link Comparable}
     * @param a the first value to compare
     * @param b the second value to compare
     * @return the larger of the two values
     */
    private Node<T> add(Node<T> node, T element) {

        if(node == null) {

            node = new Node<>(element);

            return node;
        }

        if(element.compareTo(node.getData()) > 0) {

            var result = add(node.getRight(), element);

            node.setRight(result);
        }

        else if(element.compareTo(node.getData()) < 0) {

            var result = add(node.getLeft(), element);

            node.setLeft(result);
        }

        return node;
    }

    /**
     * @return the number of elements in tree.
     */
    public Integer getSize() { return size; }

    private class Itr implements Iterator<T> {

        private Queue<T> queue = new PriorityQueue<>();

        private boolean isFirstTime = true;

        private void initializeQueue(Node<T> node) {

            if(node == null) return;

            initializeQueue(node.getLeft());

            queue.add(node.getData());

            initializeQueue(node.getRight());
        }

        @Override
        public boolean hasNext() {

            if(isFirstTime) {

                initializeQueue(node);

                isFirstTime = false;
            }

            return !queue.isEmpty();
        }

        @Override
        public T next() {

            if(queue.poll() == null) throw new NoSuchElementException();

            return queue.poll();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }
}
