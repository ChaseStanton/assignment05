package assign05;

import java.util.ArrayList;

public class ArrayListSorter<T extends Comparable<? super T>> {
	private static int insertionSortThreshold = 10;

	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list) {
		ArrayList<T> temp = new ArrayList<T>(list);
		mergesort(list, temp, 0, list.size() - 1);
	}

	private static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list, ArrayList<T> temp, int left,
			int right) {
		if (left < right) {
			if (right - left < insertionSortThreshold) {
				insertionSort(list, left, right);
			} else {

				int mid = (left + right) / 2;
				mergesort(temp, list, left, mid);
				mergesort(temp, list, mid + 1, right);
				merge(list, temp, left, mid, right);
			}
		}

	}

	private static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> list, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			T current = list.get(i);
			int before = i - 1;

			while (before >= left && list.get(before).compareTo(current) > 0) {
				list.set(before + 1, list.get(before));
				before--;
			}
			list.set(before + 1, current);
		}
	}

	private static <T extends Comparable<? super T>> void merge(ArrayList<T> list, ArrayList<T> temp, int left, int mid,
			int right) {
		int i = left;
		int j = mid + 1;

		for (int k = left; k <= right; k++) {
			if (i > mid) {
				list.set(k, temp.get(j++));
			} else if (j > right) {
				list.set(k, temp.get(i++));
			} else if (temp.get(i).compareTo(temp.get(j)) <= 0) {
				list.set(k, temp.get(i++));
			} else {
				list.set(k, temp.get(j++));
			}
		}
	}

	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list) {

	}

	public static ArrayList<Integer> generateAscending(int size) {
		return new ArrayList<Integer>();
	}

	public static ArrayList<Integer> generatePermuted(int size) {
		return new ArrayList<Integer>();

	}

	public static ArrayList<Integer> generateDescending(int size) {
		return new ArrayList<Integer>();

	}

	public static void main(String[] args) {
		ArrayList<Integer> intList = new ArrayList<>();
		intList.add(3);
		intList.add(1);
		intList.add(4);
		intList.add(1);
		intList.add(5);
		intList.add(9);

		ArrayListSorter.mergesort(intList);

		System.out.println("Sorted list: " + intList);
	}

}
