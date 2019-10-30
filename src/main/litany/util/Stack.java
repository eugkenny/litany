package litany.util;

/**
 * A stack is a last-in, first-out (LIFO) collection of elements, with two
 * principal operations:
 * <ul>
 * <li><b>push</b>, which adds an element to the collection, and
 * <li><b>pop</b>, which removes the most recently added element that was not
 * yet removed.
 * </ul>
 * 
 * @author eugkenny
 *
 * @param <E>
 */
public interface Stack<E> extends Iterable<E> {

	/**
	 * Push (add) the element to the top of the stack
	 * 
	 * @param element
	 */
	public void push(E element);

	/**
	 * Pop (remove) the element from the top of the stack
	 * 
	 * @return the element from the top of the stack
	 */
	public E pop();

	/**
	 * Return the element from the top of the stack (without removing)
	 * 
	 * @return the element from the top of the stack
	 */
	public E peek();

	/**
	 * Re whether this stack contains any elements.
	 * 
	 * @return {@code true} if this stack contains no elements, {@code false}
	 *         otherwise
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in this stack.
	 * 
	 * @return the number of elements in this stack
	 */
	public int size();
}
