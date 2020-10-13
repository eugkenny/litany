package litany.util;

/**
 * A queue is a first-in, first-out (FIFO) collection of elements, with two
 * principal operations:
 * <ul>
 * <li><b>enqueue</b>, which adds an element to the rear of the queue, and
 * <li><b>dequeue</b>, which removes an element from the front of the queue
 * </ul>
 *
 * @param <E>
 * @author eugkenny
 */

public interface Queue<E> extends Iterable<E> {

    /**
     * Enqueue (add) the element to the rear of the queue
     *
     * @param element
     */
	void enqueue(E element);

    /**
     * Dequeue (remove) the element from the front of the queue
     *
     * @return the element from the front of the queue
     */
    E dequeue();

    /**
     * Return the element from the top of the stack (without removing)
     *
     * @return the element from the top of the stack
     */
    E peek();

    /**
     * Returns whether this queue contains any elements.
     *
     * @return {@code true} if this queue contains no elements, {@code false} otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    int size();
}