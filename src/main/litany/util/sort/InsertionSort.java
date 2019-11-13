package litany.util.sort;

import java.util.Comparator;

public class InsertionSort {

	private InsertionSort() {
	}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(T[] arr){
		sort(arr, 0, arr.length);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi){
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && (arr[j].compareTo(arr[j - 1]) < 0); j--) {
				T tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}

	public static <T> void sort(T[] arr, Comparator<T> comp) {
		sort(arr, 0, arr.length, comp);
	}
	
	public static <T> void sort(T[] arr, int lo, int hi, Comparator<T> comp){
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && (comp.compare(arr[j], arr[j - 1]) < 0); j--) {
				T tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	public static void sort(int [] arr) {
		sort(arr, 0, arr.length);
	}

	public static void sort(int[] arr, int lo, int hi){
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				int tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
		
	public static void sort(double [] arr) {
		sort(arr, 0, arr.length);
	}

	public static void sort(double[] arr, int lo, int hi){
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				double tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	public static void sort(boolean [] arr) {
		sort(arr, 0, arr.length);
	}

	public static void sort(boolean[] arr, int lo, int hi){
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && Boolean.compare(arr[j], arr[j - 1]) < 0; j--) {
				boolean tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	public static void sort(byte [] arr) {
		sort(arr, 0, arr.length);
	}

	public static void sort(byte[] arr, int lo, int hi){
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				byte tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	public static void sort(short [] arr) {
		sort(arr, 0, arr.length);
	}

	public static void sort(short[] arr, int lo, int hi){
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				short tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	public static void sort(long [] arr) {
		sort(arr, 0, arr.length);
	}

	public static void sort(long[] arr, int lo, int hi){
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				long tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	public static void sort(float [] arr) {
		sort(arr, 0, arr.length);
	}

	public static void sort(float[] arr, int lo, int hi){
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				float tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
	
	public static void sort(char [] arr) {
		sort(arr, 0, arr.length);
	}

	public static void sort(char[] arr, int lo, int hi){
		for (int i = lo + 1; i <= hi; i++) {
			for (int j = i; j > lo && arr[j] < arr[j - 1]; j--) {
				char tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
			}
		}
	}
}