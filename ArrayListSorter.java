package assign05;

import java.util.ArrayList;

public class ArrayListSorter {
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list) {
		
	}
	private static<T extends Comparable<? super T>> void merge(ArrayList<T> list, ArrayList<T> left, ArrayList<T> right) {
		int i = 0, j = 0, k = 0;
		while(i < left.size() && j < right.size()) {
			if(left.get(i).compareTo(right.get(j)) < 0)
				list.set(k++, left.get(i++));
			else
				list.set(k++, right.get(j++));

		}
		while( i < left.size())
			list.set(k++, left.get(i++));
		while(j < right.size())
			list.set(k++, right.get(j++));

	}
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list) {
		
	}




}
