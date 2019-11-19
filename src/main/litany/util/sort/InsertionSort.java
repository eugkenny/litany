package litany.util.sort;

import java.util.Comparator;

/**
 * Implements the {@code InsertionSort} algorithm to sort an array of elements into ascending order. 
 * 
 * Insertion sort is a simple sorting algorithm that builds the final sorted array one item at a time. 
 * It is much less efficient (O(n^2) in the worst case) on large arrays than more advanced algorithms such as quicksort, heapsort, or merge sort.
 * 
 * It is efficient in practice for small arrays, efficient for data sets that are already substantially sorted and is stable.
 * 
 * 
 * @author eugkenny
 */
public class InsertionSort {

	// Cannot be instantiated
	private InsertionSort() {
	}


	/**
	 * Sorts the specified array of objects into ascending order, according
     * to the natural ordering of its elements.
     * 
     * All elements in the array must implement the {@link Comparable} interface.
     * 
	 * @param arr the array to be sorted
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(T[] arr){
		sort(arr, 0, arr.length);
	}
	
	/**
     * Sorts the specified range of the specified array of objects into ascending order,
     * according to the natural ordering of its elements.
     * 
     * The range to be sorted extends from the index {@code lo}, inclusive,
     * to the index {@code hi}, exclusive.
     * 
     * All elements in the array must implement the {@link Comparable} interface.
     * 
     * @param arr the array to be sorted
     * @param lo the index of the first element, inclusive, to be sorted
     * @param hi the index of the last element, exclusive, to be sorted
     * 
     * @throws IllegalArgumentException if {@code lo > hi}
     * @throws ArrayIndexOutOfBoundsException if {@code lo < 0} or {@code hi > arr.length}
     */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi){
		checkIndices(arr.length, lo, hi);
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && (arr[j].compareTo(arr[j - 1]) < 0); j--) {
				T tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	/**
	 * Sorts the specified array of objects into ascending order, according
     * to the order induced by the specified comparator.
     * 
	 * @param arr the array to be sorted
	 */

	public static <T> void sort(T[] arr, Comparator<T> comp) {
		sort(arr, 0, arr.length, comp);
	}

	/**
     * Sorts the specified range of the specified array of objects into ascending order, 
     * according to the order induced by the specified comparator.
     * 
     * The range to be sorted extends from the index {@code lo}, inclusive,
     * to the index {@code hi}, exclusive.
     * 
     * All elements in the array must implement the {@link Comparable} interface.
     * 
     * @param arr the array to be sorted
     * @param lo the index of the first element, inclusive, to be sorted
     * @param hi the index of the last element, exclusive, to be sorted
     * 
     * @throws IllegalArgumentException if {@code lo > hi}
     * @throws ArrayIndexOutOfBoundsException if {@code lo < 0} or {@code hi > arr.length}
     */
	public static <T> void sort(T[] arr, int lo, int hi, Comparator<T> comp){
		checkIndices(arr.length, lo, hi);
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && (comp.compare(arr[j], arr[j - 1]) < 0); j--) {
				T tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}

	/**
     * Sorts the specified array into ascending order.
     * 
     * @param arr the array to be sorted
     */
	public static void sort(int [] arr) {
		sort(arr, 0, arr.length);
	}

	/**
     * Sorts the specified range of the array into ascending order.
     * The range to be sorted extends from the index {@code lo}, inclusive,
     * to the index {@code hi}, exclusive.
     * 
     * @param arr the array to be sorted
     * @param lo the index of the first element, inclusive, to be sorted
     * @param hi the index of the last element, exclusive, to be sorted
     * 
     * @throws IllegalArgumentException if {@code lo > hi}
     * @throws ArrayIndexOutOfBoundsException if {@code lo < 0} or {@code hi > arr.length}
     */
	public static void sort(int[] arr, int lo, int hi){
		checkIndices(arr.length, lo, hi);
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				int tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
		
	/**
     * Sorts the specified array into ascending order.
     * 
     * @param arr the array to be sorted
     */
	public static void sort(double [] arr) {
		sort(arr, 0, arr.length);
	}

	/**
     * Sorts the specified range of the array into ascending order.
     * The range to be sorted extends from the index {@code lo}, inclusive,
     * to the index {@code hi}, exclusive.
     * 
     * @param arr the array to be sorted
     * @param lo the index of the first element, inclusive, to be sorted
     * @param hi the index of the last element, exclusive, to be sorted
     * 
     * @throws IllegalArgumentException if {@code lo > hi}
     * @throws ArrayIndexOutOfBoundsException if {@code lo < 0} or {@code hi > arr.length}
     */
	public static void sort(double[] arr, int lo, int hi){
		checkIndices(arr.length, lo, hi);
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				double tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	/**
     * Sorts the specified array into ascending order.
     * 
     * @param arr the array to be sorted
     */
	public static void sort(boolean [] arr) {
		sort(arr, 0, arr.length);
	}

	/**
     * Sorts the specified range of the array into ascending order.
     * The range to be sorted extends from the index {@code lo}, inclusive,
     * to the index {@code hi}, exclusive.
     * 
     * @param arr the array to be sorted
     * @param lo the index of the first element, inclusive, to be sorted
     * @param hi the index of the last element, exclusive, to be sorted
     * 
     * @throws IllegalArgumentException if {@code lo > hi}
     * @throws ArrayIndexOutOfBoundsException if {@code lo < 0} or {@code hi > arr.length}
     */
	public static void sort(boolean[] arr, int lo, int hi){
		checkIndices(arr.length, lo, hi);
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && Boolean.compare(arr[j], arr[j - 1]) < 0; j--) {
				boolean tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	/**
     * Sorts the specified array into ascending order.
     * 
     * @param arr the array to be sorted
     */
	public static void sort(byte [] arr) {
		sort(arr, 0, arr.length);
	}

	/**
     * Sorts the specified range of the array into ascending order.
     * The range to be sorted extends from the index {@code lo}, inclusive,
     * to the index {@code hi}, exclusive.
     * 
     * @param arr the array to be sorted
     * @param lo the index of the first element, inclusive, to be sorted
     * @param hi the index of the last element, exclusive, to be sorted
     * 
     * @throws IllegalArgumentException if {@code lo > hi}
     * @throws ArrayIndexOutOfBoundsException if {@code lo < 0} or {@code hi > arr.length}
     */
	public static void sort(byte[] arr, int lo, int hi){
		checkIndices(arr.length, lo, hi);
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				byte tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	/**
     * Sorts the specified array into ascending order.
     * 
     * @param arr the array to be sorted
     */
	public static void sort(short [] arr) {
		sort(arr, 0, arr.length);
	}
	
	/**
     * Sorts the specified range of the array into ascending order.
     * The range to be sorted extends from the index {@code lo}, inclusive,
     * to the index {@code hi}, exclusive.
     * 
     * @param arr the array to be sorted
     * @param lo the index of the first element, inclusive, to be sorted
     * @param hi the index of the last element, exclusive, to be sorted
     * 
     * @throws IllegalArgumentException if {@code lo > hi}
     * @throws ArrayIndexOutOfBoundsException if {@code lo < 0} or {@code hi > arr.length}
     */
	public static void sort(short[] arr, int lo, int hi){
		checkIndices(arr.length, lo, hi);
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				short tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	/**
     * Sorts the specified array into ascending order.
     * 
     * @param arr the array to be sorted
     */
	public static void sort(long [] arr) {
		sort(arr, 0, arr.length);
	}

	/**
     * Sorts the specified range of the array into ascending order.
     * The range to be sorted extends from the index {@code lo}, inclusive,
     * to the index {@code hi}, exclusive.
     * 
     * @param arr the array to be sorted
     * @param lo the index of the first element, inclusive, to be sorted
     * @param hi the index of the last element, exclusive, to be sorted
     * 
     * @throws IllegalArgumentException if {@code lo > hi}
     * @throws ArrayIndexOutOfBoundsException if {@code lo < 0} or {@code hi > arr.length}
     */
	public static void sort(long[] arr, int lo, int hi){
		checkIndices(arr.length, lo, hi);
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				long tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	/**
     * Sorts the specified array into ascending order.
     * 
     * @param arr the array to be sorted
     */
	public static void sort(float [] arr) {
		sort(arr, 0, arr.length);
	}

	/**
     * Sorts the specified range of the array into ascending order.
     * The range to be sorted extends from the index {@code lo}, inclusive,
     * to the index {@code hi}, exclusive.
     * 
     * @param arr the array to be sorted
     * @param lo the index of the first element, inclusive, to be sorted
     * @param hi the index of the last element, exclusive, to be sorted
     * 
     * @throws IllegalArgumentException if {@code lo > hi}
     * @throws ArrayIndexOutOfBoundsException if {@code lo < 0} or {@code hi > arr.length}
     */
	public static void sort(float[] arr, int lo, int hi){
		checkIndices(arr.length, lo, hi);
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				float tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	/**
     * Sorts the specified array into ascending order.
     * 
     * @param arr the array to be sorted
     */
	public static void sort(char [] arr) {
		sort(arr, 0, arr.length);
	}

	/**
     * Sorts the specified range of the array into ascending order.
     * The range to be sorted extends from the index {@code lo}, inclusive,
     * to the index {@code hi}, exclusive.
     * 
     * @param arr the array to be sorted
     * @param lo the index of the first element, inclusive, to be sorted
     * @param hi the index of the last element, exclusive, to be sorted
     * 
     * @throws IllegalArgumentException if {@code lo > hi}
     * @throws ArrayIndexOutOfBoundsException if {@code lo < 0} or {@code hi > arr.length}
     */
	public static void sort(char[] arr, int lo, int hi){
		checkIndices(arr.length, lo, hi);
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				char tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	/**
	 * Checks that the indices {@code lo} and {@code hi} are within the range 
	 * of the array and that {@code lo < hi}
	 */
	private static void checkIndices(int length, int lo, int hi) {
		if (lo > hi) {
			throw new IllegalArgumentException("lo: " + lo + " > hi: " + hi);
		}
		if (lo < 0) {
			throw new ArrayIndexOutOfBoundsException("lo: " + lo + " < 0");
		}
		if(hi > length) {
			throw new ArrayIndexOutOfBoundsException("hi: " + hi + " > length: " + length);
		}
	}
}